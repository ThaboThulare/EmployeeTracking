/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Thabo
 * Created: Sep 15, 2017
 */

/* table : login */



create table user_detail(
     id integer auto_increment not null primary key,
     role_id integer not null,
     name varchar(64) not null,
     last_name varchar(64) not null,
     id_number varchar(16) not null,
     constraint role_fk foreign key (role_id) references role (id)
);

create table scanner(
    id integer auto_increment not null primary key,
    user_id integer(16) not null,
    login_time_stamp date not null,
    logout_time_stamp date,
    constraint user_detail_fk foreign key (user_id) references user_detail (id)
);

create table user_role(
    id integer auto_increment not null primary key,
    user_role_description varchar(32) not null
);

create table login (
    id integer auto_increment not null primary key,
    user_role integer not null,
    user_name varchar(32) not null, 
    password varchar(32) not null,
    first_name varchar(32) not null,
    last_name varchar(32) not null, 
    enabled boolean not null,

);

create table class_detail(
   id integer auto_increment not null primary key,
   class_name varchar(64) not null primary key,
);

create lecture_module(
   id integer auto_increment not nul primary key,
   class_detail_id integer not null,
   lecture_id integer not null,
   start_time date not null,
   end_time date not null,
   day_of_week date not null,
   name varchar(64) not null,
   constraint user_detail_fk foreign key (lecture_id) references user_detail (id),
   constraint class_detail_fk foreign key (class_detail_id) references class_detail (id)
);