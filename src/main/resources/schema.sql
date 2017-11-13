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



create table entity_type(
     id integer auto_increment not null primary key,
     entity_type_desc varchar(45) not null
);


create table user_role(
    id integer auto_increment not null primary key,
    role_desc varchar(45) not null
);


create table status(
    id integer auto_increment not null primary key,
    status_desc varchar(45) not null
);

create table vanue(
    id integer auto_increment not null primary key,
    vanue_desc varchar(45) not null
);

create table subject(
     id integer auto_increment not null primary key,
     subject_desc varchar(45) not null

);

create table entity(
    id integer auto_increment not null primary key,
    first_name varchar(45) not null,
    surname varchar(45) not null,
    gender varchar(10) not null,
    id_number varchar(13) not null,
    status_id integer not null,
    constraint status_fk1 foreign key (status_id) references status (id)

);

create table entity_role(
     id integer auto_increment not null primary key,
     entity_type_id integer not null,
     user_role_id integer not null,
     entity_id integer not null,
     constraint entity_type_fk1 foreign key (entity_type_id) references entity_type (id),
     constraint user_role_fk1 foreign key (user_role_id) references user_role (id),
     constraint entity_fk1 foreign key (entity_id) references entity (id)
);


create table time_table(
    id integer auto_increment not null primary key,
    start_time timestamp not null,
    end_time timestamp not null,
    vanue_id integer not null,
    subject_id integer not null,
    status_id integer not null,
    constraint vanue_fk1 foreign key (vanue_id) references vanue (id),
    constraint subject_fk1 foreign key (subject_id) references subject (id),
    constraint status_fk2 foreign key (status_id) references status (id)
);


create table class_list(
    id integer auto_increment not null primary key,
    entity_id integer not null,
    subject_id integer not null,
    status_id integer not null,
    constraint entity_fk2 foreign key (entity_id) references entity (id),
    constraint subject_fk2 foreign key (subject_id) references subject (id),
    constraint status_fk3 foreign key (status_id) references status (id)
);

create table lecture_subject_list(
    id integer auto_increment not null primary key,
    entity_id integer not null,
    status_id integer not null,
    subject_id integer not null,
    constraint subject_fk3 foreign key (subject_id) references subject (id),
    constraint status_fk4 foreign key (status_id) references status (id),
    constraint entity_fk3 foreign key (entity_id) references entity (id)
);


create table log_history(
      id integer auto_increment not null primary key,
      time_in timestamp,
      time_out timestamp,
      vanue_id integer not null,
      entity_id integer not null,
      constraint entity_fk4 foreign key (entity_id) references entity (id),
      constraint vanue_fk2 foreign key (vanue_id) references vanue (id)

);

