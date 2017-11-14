var admin = angular.module('admin', ['ngRoute']);

admin.config(['$routeProvider', function ($routeProvider) {
        $routeProvider
                .when('/entities', {
                    'templateUrl': '/html/entities.html',
                    'controller': 'adminCtrl'
                }).when('/register', {
                    'templateUrl': '/html/register.html',
                    'controller': 'registerCtrl'
                })
                .otherwise({
                    redirectTo: '/entities'
                });
    }]);



admin.controller('adminCtrl', function ($scope, $rootScope, $http, $filter) {


    $scope.init = function () {
        $scope.getAllEntities();
    };


    $scope.getAllEntities = function () {
        console.log('get all enetities');
        $http({
            url: '/api/entities',
            method: 'get'
        }).success(function (data, status) {
            if (status === 200) {
                console.log('retrived successfully');
                $scope.entitties = data;
                console.log(data);
                
            } else {
                console.log('status:' + status);
                $rootScope.error = "error status code : " + status;
                
            }
        }).error(function (error) {
            $rootScope.message = "Oops, we received your request, but there was an error processing it";
        });
    };

    $scope.closeNotification = function () {
        $rootScope.message = undefined;
    };


});


admin.controller('registerCtrl', function ($scope, $rootScope, $http, $filter) {


    $scope.entities = {};


});