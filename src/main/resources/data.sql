/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  User
 * Created: Sep 15, 2017
 */




insert into entity_type(entity_type_desc) values('admin');
insert into entity_type(entity_type_desc) values('lecture');
insert into entity_type(entity_type_desc) values('student');

insert into user_role(role_desc) values('admin');
insert into user_role(role_desc) values('lecture');
insert into user_role(role_desc) values('student');


--insert into entity_role(entity_type_id, user_role_id, entity_id) values(1,2,1);
--insert into entity_role(entity_type_id, user_role_id, entity_id) values(2,2,3);
--insert into entity_role(entity_type_id, user_role_id, entity_id) values(3,3,2);
--insert into entity_role(entity_type_id, user_role_id, entity_id) values(3,3,3);

insert into status(status_desc) values('active');
insert into status(status_desc) values('inactive');
insert into status(status_desc) values('suspended');
insert into status(status_desc) values('cancelled');



insert into vanue(vanue_desc) values('Room 1');
insert into vanue(vanue_desc) values('Room 2');
insert into vanue(vanue_desc) values('Room 3');
insert into vanue(vanue_desc) values('Room 4');

insert into subject(subject_desc) values('Network Systems');
insert into subject(subject_desc) values('Project Design');
insert into subject(subject_desc) values('Digital Systems');
insert into subject(subject_desc) values('Database');
insert into subject(subject_desc) values('Mathematics');
insert into subject(subject_desc) values('System Analysis');

insert into time_table(start_time,end_time,vanue_id,subject_id,status_id) values('2017-08-05 07:00:00', '2017-08-05 08:00:00', 1, 3, 1);
insert into time_table(start_time,end_time,vanue_id,subject_id,status_id) values( '2017-08-05 10:00:00', '2017-08-05 11:00:00', 2, 1, 1);

insert into entity(first_name,surname,gender, id_number,status_id ) values('Thabo', 'Thulare', 'male', '9308', 1);
insert into entity(first_name,surname,gender, id_number,status_id ) values('Nokwanda', 'Zuke', 'Female', '9308', 1);
insert into entity(first_name,surname,gender, id_number,status_id ) values('Carol', 'Nonyane', 'Female', '6610', 1);
insert into entity(first_name,surname,gender, id_number,status_id ) values('Mark', 'Mark', 'male', '5610', 1);

insert into class_list(entity_id,subject_id,status_id) values(3,3,1);
insert into class_list(entity_id,subject_id,status_id) values(2,2,1);

insert into lecture_subject_list(entity_id,subject_id,status_id) values(3, 3, 1);
insert into lecture_subject_list(entity_id,subject_id,status_id) values(3, 1, 1);

insert into log_history(time_in, time_out, vanue_id, entity_id) values('2017-08-05 07:00:00', '2017-08-05 07:50:00',1,2);
insert into log_history(time_in, time_out, vanue_id, entity_id) values('2017-08-05 10:00:00', '2017-08-05 10:40:00',2,3);