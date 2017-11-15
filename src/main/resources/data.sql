/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  User
 * Created: Sep 15, 2017
 */





insert into user_role(role_desc) values('admin');
insert into user_role(role_desc) values('lecture');
insert into user_role(role_desc) values('student');


insert into vanue(vanue_desc) values('Room 1');
insert into vanue(vanue_desc) values('Room 2');
insert into vanue(vanue_desc) values('Room 3');
insert into vanue(vanue_desc) values('Room 4');





insert into entity_class(first_name,surname,gender, id_number,is_finger_print,user_role_id) values('Thabo', 'Thulare', 'male', '9308',true,1);
insert into entity_class(first_name,surname,gender, id_number,is_finger_print,user_role_id) values('Nokwanda', 'Zuke', 'Female', '9308',true,2);
insert into entity_class(first_name,surname,gender, id_number,is_finger_print, user_role_id) values('Carol', 'Nonyane', 'Female', '6610',false,3);
insert into entity_class(first_name,surname,gender, id_number,is_finger_print,user_role_id) values('Mark', 'Mark', 'male', '5610',true,3);

insert into subject(subject_desc, entity_id) values('Network Systems', 1);
insert into subject(subject_desc, entity_id) values('Project Design', 2);
insert into subject(subject_desc, entity_id) values('Digital Systems', 3);
insert into subject(subject_desc, entity_id) values('Database', 1);
insert into subject(subject_desc, entity_id) values('Mathematics', 1);
insert into subject(subject_desc, entity_id) values('System Analysis', 2);


insert into time_table(start_time,end_time,vanue_id,subject_id) values('2017-08-05 07:00:00', '2017-08-05 08:00:00', 1, 3);
insert into time_table(start_time,end_time,vanue_id,subject_id) values( '2017-08-05 10:00:00', '2017-08-05 11:00:00', 2, 1);

insert into login (user_name, password, enabled, entity_id) values('admin', 'secret',true, 1);
insert into login (user_name, password, enabled, entity_id) values('student', 'secret', true, 2);
insert into login (user_name, password, enabled, entity_id) values('lecture', 'secret', true, 3);


insert into log_history(time_table_id, entity_id,is_attended ) values(1,2,true);
insert into log_history(time_table_id, entity_id,is_attended) values(2,3, false);