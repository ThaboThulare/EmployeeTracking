var admin = angular.module('admin', ['ngRoute']);

admin.config(['$routeProvider', function ($routeProvider) {
        $routeProvider
                .when('/entities', {
                    'templateUrl': '/html/entities.html',
                    'controller': 'entityCtrl'
                }).when('/register', {
            'templateUrl': '/html/register.html',
            'controller': 'registerCtrl'
        }).when('/studentList', {
            'templateUrl': '/html/studentList.html',
            'controller': 'studentListCtrl'
        }).when('/lectureList', {
            'templateUrl': '/html/lectureList.html',
            'controller': 'lectureListCtrl'
        })
                .otherwise({
                    redirectTo: '/entities'
                });
    }]);


admin.controller('adminCtrl', function ($scope, $rootScope, $http, $cookies, $window) {

    $scope.init = function () {
        if ($cookies.token == undefined) {

            $window.location.href = "/login?state=" + encodeURIComponent($window.location.href);
        } else {
            $scope.validate($cookies.token);

        }
    };

    $scope.validate = function (token) {
        $http({
            method: 'POST',
            url: '/validate',
            headers: {
                "Content-Type": "text/html"
            },
            data: token
        }).success(function (data, status) {
            $rootScope.session = data;

            if ($rootScope.session.role != "admin") {
                $window.location.href = "/logout";
            }

            $http.defaults.headers.common['Authorization'] = 'Basic ' + $cookies.token;
        }).error(function (error, status) {
            $window.location.href = "/logout";
        });
    };

});

admin.controller('entityCtrl', function ($scope, $rootScope, $http, $filter) {

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


admin.controller('registerCtrl', function ($scope, $rootScope, $http, $routeParams, $location, $filter) {


    $scope.entities = {};
    $scope.subjects = [];
    $scope.isSubject;
    $scope.entityId;

    $scope.init = function () {
        $scope.isSubject = false;
        $scope.getAllEntities();
    };


    $scope.addRemoveSubject = function () {

        if ($scope.isSubject) {
            $scope.subjects = [];
            console.log($scope.subjects);
        } else {
            $scope.subjects[0] = {};
            console.log($scope.subjects);
        }
    };

    $scope.addMoreSubject = function () {
        $scope.subjects[$scope.subjects.length] = {};
    };

    $scope.removeMoreSubject = function () {
        $scope.subjects.pop();
        if ($scope.subjects.length == 0 || !$scope.isSubject) {
            $scope.subjects = [];
            $scope.isSubject = undefined;
        }
    };

    $scope.registerClient = function (form) {

        if (form.$invalid) {
            console.log("Form Validation Failure");
        } else {
            console.log("Form Validation Success");

            console.log($scope.entities);

            console.log($scope.subjects);
            $scope.entities.subjects = $scope.subjects;
            $scope.entities.isFingerPrint = false;
            console.log($scope.entities.subjects)
            $http({
                url: '/api/entity',
                method: 'post',
                headers: {
                    'Content-Type': 'application/json',
                },
                data: $scope.entities
            }).success(function (data, status) {
                if (status == 200) {
                    console.log('User Registered succesfullly');
                    $location.path("/entities");
                } else {
                    console.log('status:' + status);
                }
            }).error(function (error) {
                console.log(error);
                $rootScope.message = error;
            });
        }

    };

    $scope.increment = 3;

    $scope.getFingerPrint = function (entityId)
    {
        $http({
            url: '/api/register/' + entityId + $scope.increment,
            method: 'get'
        }).success(function (data, status) {
            if (status == 200) {

                $scope.updateEntity(entityId);
            } else {
                console.log('status:' + status);
                $rootScope.error = "error status code : " + status;

            }
        }).error(function (error) {
            console.log(error);
            $rootScope.error = error;
            ;
        });
    };

    $scope.updateEntity = function (entityId) {
     			$scope.isFingerPrint = true;

        $http({
            url: '/api/updateEntity/' + entityId,
            method: 'put',
            headers: {
                'Content-Type': 'application/json'
            },
            data: $scope.isFingerPrint
        }).success(function (data, status) {
            console.log('get success code:' + status);
            if (status === 200) {
                console.log(status);
                $location.path("/entities");
            } else {
                console.log('status:' + status);
            }
        })
                .error(function (error) {
                    $rootScope.message = "Oops we recieved your request but there was a problem processing it";
                    console.log(error);
                });

    };


});

admin.controller('lectureListCtrl', function ($scope, $rootScope, $http, $filter) {


    $scope.init = function () {
        $scope.getAllLectures();
    };


    $scope.getAllLectures = function () {
        console.log('get all lectures');
        $http({
            url: '/api/entities',
            method: 'get'
        }).success(function (data, status) {
            if (status === 200) {
                console.log('retrived successfully');
                $scope.entitties = data;

                console.log('kkkk' + $scope.entitties);
                console.log('Id ' + $scope.entitties.userRole.roleDesc);
                if ($scope.entitties.userRole.id == 2)
                {
                    $scope.lectureList = $scope.entities;
                }
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

admin.controller('studentListCtrl', function ($scope, $rootScope, $http, $filter) {


    $scope.init = function () {
        $scope.getAllStudent();
    };


    $scope.getAllStudent = function () {
        console.log('get all students');
        $http({
            url: '/api/entities',
            method: 'get'
        }).success(function (data, status) {
            if (status === 200) {
                console.log('retrived successfully');

                $scope.entitties = data;

                console.log($scope.entitties);
                $scope.role = $scope.entitties.userRole;
                console.log('Id ' + $scope.role.id);
                if ($scope.entitties.userRole.id == 3)
                {
                    $scope.studentList = $scope.entitties;
                }
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