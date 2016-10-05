/**********************************************
 * 
 *  drop, create ���� ������ Ȯ���ϸ鼭 �����ϼ��� 
 * 
 *  insert �κ��� �� �Ʒ��� ����
 *  
 **********************************************/


/* u_user ���̺� - ȸ������ 
 * 
 * u_level : ���(0:�Ϲ�ȸ��,1:�����  2:������ 3:���� ����) */
drop table u_user;
create table u_user(
   u_uid varchar2(20) not null,
   u_email varchar2(50) not null,
   u_name varchar2(15) not null,
   u_password varchar2(15) not null,
   u_reg_date date not null,
   u_level number default 0,
   constraint u_user_pk primary key (u_uid) 
);

drop sequence user_seq;
create sequence user_seq;

/* franchise ���̺� - ���������� ����*/
drop table franchise;

create table franchise(
   franchise_num number not null,
   franchise_name varchar2(30) not null,
   franchise_img varchar2(100) not null,
   franchise_introduce varchar2(4000),
   franchise_visit number default 0,
   constraint franchise_pk primary key (franchise_num)
);

drop sequence franchise_seq;
create sequence franchise_seq;

/* franchise_menu ���̺� - ���������� �޴� ����*/
drop table franchise_menu;

create table franchise_menu(
   fmenu_num number not null,
   franchise_num number not null,
   fmenu_name varchar2(50) not null,
   fmenu_price number default 0,
   fmenu_img varchar2(100) not null,
   fmenu_introduce varchar(4000),
   constraint franchise_menu_pk primary key (fmenu_num),
   constraint franchise_menu_fk foreign key (franchise_num) references franchise(franchise_num) on delete cascade
);

drop sequence franchise_menu_seq;
create sequence franchise_menu_seq;

/* franchise_reply ���̺� - ���������� ��� ����*/
drop table franchise_reply;

create table franchise_reply(
   freply_num number not null,
   franchise_num number not null,
   u_uid varchar2(20) not null,
   freply_content varchar2(500) not null,
   freply_nickname varchar2(15) not null,
   freply_reg_date date not null,
   constraint franchise_reply_pk primary key (freply_num),
   constraint franchise_reply_fk1 foreign key (franchise_num) references franchise(franchise_num)
);

drop sequence franchise_reply_seq;
create sequence franchise_reply_seq;

/* private_cafe ���̺� - ����ī�� ���� (����ڸ� ��� ������ ����)*/
drop table private_cafe;

create table private_cafe(
   pcafe_num number not null ,
   u_uid varchar2(20) not null ,
   pcafe_name varchar2(30) not null,
   pcafe_address varchar2(100),
   pcafe_phone varchar2(30),
   pcafe_time varchar2(100), 
   pcafe_url varchar2(50),
   pcafe_introduce varchar2(4000),
   pcafe_hash_tag varchar2(500),
   pcafe_img varchar2(2000) not null, 
   pcafe_visit number default 0,
   pcafe_reg_date date not null,
   constraint private_cafe_pk primary key (pcafe_num)
);

drop sequence private_cafe_seq;
create sequence private_cafe_seq;

/* private_cafe_menu ���̺� - ����ī�� �޴� ����(����ڸ� ��ϰ����� ����) */
drop table private_cafe_menu;

create table private_cafe_menu(
   pmenu_num number not null ,
   pcafe_num number not null ,
   pmenu_name varchar2(50) not null,
   pmenu_price number default 0,
   pmenu_introduce varchar2(4000),
   pmenu_img varchar2(100) not null,
   constraint private_cafe_menu_pk primary key (pmenu_num),
   constraint private_cafe_menu_fk foreign key (pcafe_num) references private_cafe(pcafe_num)
);

drop sequence private_cafe_menu_seq;
create sequence private_cafe_menu_seq;

/* private_cafe_reply ���̺� - ����ī�� ��� ���� */
drop table private_cafe_reply;

create table private_cafe_reply(
   preply_num number not null ,
   pcafe_num number not null ,
   u_uid varchar2(20) not null ,
   preply_content varchar2(500),
   preply_nickname varchar2(15) not null, 
   preply_reg_date date not null,
   constraint private_cafe_reply_pk primary key (preply_num),
   constraint private_cafe_reply_fk1 foreign key (pcafe_num) references private_cafe(pcafe_num)
);

drop sequence private_cafe_reply_seq;
create sequence private_cafe_reply_seq;

/* u_like ���̺�  - ���ƿ� ���� ���� ��� ����*/
drop table u_like;

create table u_like(
   like_num number not null,
   u_uid varchar2(20) not null,
   franchise_num number,
   pcafe_num number,
   custom_num number,
   fmenu_num number,
   pmenu_num number,
   like_reg_date date not null,
   constraint u_like_pk primary key (like_num)
); 


drop sequence u_like_seq;
create sequence u_like_seq;

/* bookmark ���̺� - ���ã��*/
drop table bookmark;

create table bookmark(
   bookmark_num number not null,
   u_uid varchar2(20) not null,
   franchise_num number,
   pcafe_num number,
   custom_num number,
   bookmark_reg_date date not null,
   constraint bookmark_pk primary key (bookmark_num),
   constraint bookmark_fk1 foreign key (u_uid) references u_user(u_uid), 
   constraint bookmark_fk2 foreign key (franchise_num) references franchise(franchise_num),
   constraint bookmark_fk3 foreign key (pcafe_num) references private_cafe(pcafe_num)
);

drop sequence bookmark_seq;
create sequence bookmark_seq;

/* customizing ���̺� - Ŀ���Ҹ���¡ ���� ���̺� */
drop table customizing;

create table customizing(
   custom_num number not null,
   franchise_num number not null,
   u_uid varchar2(20) not null,
   custom_name varchar2(50) not null,
   custom_introduce varchar2(4000),
   custom_recipe varchar2(4000) not null,
   custom_img varchar2(100) not null,
   custom_hash_tag varchar2(500),
   custom_visit number default 0,
   custom_reg_date date not null,
   constraint customizing_pk primary key (custom_num),
   constraint customizing_fk1 foreign key (franchise_num) references franchis (franchise_num)
);

drop sequence customizing_seq;
create sequence customizing_seq;

/* customizing_reply ���̺� - Ŀ���͸���¡ �޴� ��� */
drop table customizing_reply;

create table customizing_reply(
   creply_num number not null,
   custom_num number not null,
   u_uid varchar2(20) not null,
   creply_content varchar2(500) not null,
   creply_nickname varchar2(15) not null,
   creply_reg_date date not null,
   constraint customizing_reply_pk primary key (creply_num),
   constraint customizing_reply_fk1 foreign key (custom_num) references customizing(custom_num)
);

drop sequence customizing_reply_seq;
create sequence customizing_reply_seq;

/* F_log ���̺� - ���������� �α�
 * 
 * F_log_change : 0[�߰�] 1[����]2[����]*/
drop table F_log;

create table F_log(
   franchise_log_seq number(20) not null,
   franchise_num_log number(10) not null,
   u_uid varchar2(20) not null,
   franchise_reg_date_log date not null,
   franchise_change_log number(20) default 0,
   franchise_admin_log varchar2(40) not null, 
   franchise_message_log varchar2(100) not null,
   constraint F_log_pk primary key (franchise_log_seq),
   constraint F_log_fk1 foreign key (Brand_code) references franchise(franchise_num)
);

drop sequence F_log_seq;
create sequence F_log_seq;

/* P_log ���̺� - ����ī�� �α�
 * 
 * P_log_change : 0[�߰�] 1[����] 2[����]
 * P_log_controller : 0 [�����ڰ� ����] 1 [������ ����] */
drop table P_log;

create table P_log(
   P_log_seq number(20) not null,
   Pcafe_num number(30) not null, 
   U_uid varchar2(20) not null,
   P_log_reg_date date not null,
   P_log_change number(20) default 0,
   P_log_controller varchar2(40) default 0,
   P_log_message varchar2(100) not null,
   P_log_likecontroller varchar2(20) not null,
   P_log_Bookmarkcontroller varchar2(20) not null,
   constraint P_log_pk primary key (P_log_seq),
   constraint P_log_fk1 foreign key (Pcafe_num) references private_cafe(pcafe_num)
);

drop sequence P_log_seq;
create sequence P_log_seq;

/* declared ���̺� - �Խù� Ȥ�� ��� �Ű�� �Ű��� ������ ����Ǵ� ���̺� 
 * 
 * d_target_path : 0[���������� ���] 1[����ī�� ���] 2[Ŀ���͸���¡ ���] */
drop table declared;

create table declared(
 d_seq number(20) not null PRIMARY KEY,
 d_target_path number(20) not null,
 d_target_num number(20) not null,
 d_target_id number(20) not null,
 d_mem_id varchar2(20) not null,
 d_target_mem_id varchar2(20) not null,
 d_reg_date date not null,
 d_content varchar2(4000),
 d_state number(20) default(0),
 d_comment varchar2(2000)
);

drop sequence declared_seq;
create sequence declared_seq;

/* mlog ���̺� - ȸ������ �α� ���̺�
 * 
 * mlog_num : 0-���� 1-���� 2-��Ÿ */
drop table mlog;

create table mlog(
   mlog_seq number(20) not null, 
   mlog_reg_date date not null,
   mlog_num number(20) not null,
   mlog_processInfo varchar2(20) not null,
   mlog_content varchar2(200) not null,
   target_id varchar2(20) not null,
   constraint mlog_pk primary key (mlog_seq)
);

drop sequence mlog_seq;
create sequence mlog_seq;

/*user_log - ȸ�� �α� ���̺� */
drop table user_log;

create table user_log(
	u_log_seq number not null,
	u_uid varchar2(20) not null,
	u_log_reg_date date not null,
	u_log_change number not null,
	u_log_message varchar2(200) not null,
	constraint u_log_pk primary key (u_log_seq)
);

drop sequence user_log_seq;
create sequence user_log_seq;

/*user_count_log �޴��� ���� �������� ī��Ʈ �α� ���̺�*/

drop table user_count_log;

create table user_count_log(
	ucnt_log_seq number not null,
	ucnt_log_reg_date date not null,
	ucnt_total number default(0),
	ucnt_log_main number default(0),
	ucnt_log_franchise number default(0),
	ucnt_log_private number default(0),
	ucnt_log_custom number default(0),
	ucnt_log_qna number default(0),
	ucnt_log_notice number default(0),
	constraint ucnt_log_pk primary key (ucnt_log_seq)
);

drop sequence user_count_log_seq;
create sequence user_count_log_seq;

/*
 * user_menu_log �޴��� ���� �α� ���̺�
 * umenu_name : 0[����ī��] 1[Ŀ���Ҹ޴�] 2[���������� ���] 3[����ī�� ���] 4[Ŀ���� ���]
 * umenu_log_state : 0[���] 1[����] 2[����] 3[�Ű�]
 * */
drop table user_menu_log;

create table user_menu_log(
	umenu_log_seq number not null,
	umenu_log_reg_date date not null,
	umenu_log_u_uid varchar2(20) not null,
	umenu_name number default(0),
	umenu_log_state number default(0),
	umenu_log_message varchar2(200) not null,
	constraint umenu_log_pk primary key (umenu_log_seq)
);

drop sequence umenu_log_seq;
create sequence umenu_log_seq;

/* ���� admin ���̺� */

/* Q&A ���̺� - ������, ���ǻ��� ���� 
 * 
 * qa_f_option : 0:����������ī�乮��,1:����ī�乮��,2:Ŀ���͸��ֹ̹���,3:�̺�Ʈ����,4:���ǻ���
 * qa_answer : 0 ������� ,1 ������
 * */
drop table qna;
create table qna(
	qa_num number not null primary key,
	qa_email varchar2(50) not null,
	qa_title varchar2(100) not null,
	qa_content varchar2(4000) not null,
	pa_password varchar2(15) not null,
	qa_reg_date date not null,
	qa_f_option number default(0),
	qa_answer number default(0)
);

drop sequence qna_seq;
create sequence qna_seq;

/* notice ���̺� - �������� */
DROP TABLE NOTICE;
create table notice(
   notice_num number not null primary key,
   notice_title varchar2(100) not null,
   notice_content varchar2(500) not null,
   notice_reg_date date not null,
   notice_hit number default(0),
   notice_img varchar2(2000),
   notice_uid varchar2(20) not null,
   constraint notice_fk foreign key (notice_uid) references u_user(u_uid)

);
DROP SEQUENCE NOTICE_SEQ;
create sequence notice_seq;

/* notice ���̺� - �������� */
drop table event;
create table event(
   event_num number not null primary key,
   event_title varchar2(100) not null,
   event_content varchar2(500) not null,
   event_reg_date date not null,
   event_hit number default(0),
   event_img varchar2(2000),
   event_uid varchar2(20),
   constraint event_fk foreign key (event_uid) references u_user(u_uid)
);

drop sequence event_seq;
create sequence event_seq;

/* �����ڿ� �������� ���̺� */
drop table admin_notice;
create table admin_notice(
   admin_notice_num number not null primary key,
   admin_notice_title varchar2(100) not null,
   admin_notice_content varchar2(500) not null,
   admin_notice_reg_date date not null,
   u_uid varchar2(20) not null,
   admin_notice_img varchar2(2000),

   constraint admin_notice_fk foreign key (u_uid) references u_user(u_uid)
);

drop sequence admin_notice_seq;
create sequence admin_notice_seq;

drop table admin_notice_log;
create table admin_notice_log(
  an_log_num number not null primary key,
  an_log_uid varchar2(20) not null,
  an_log_reg_date date not null,
  an_log_change number not null,
  an_log_message varchar2(100) not null,
  
  constraint admin_notice_log_fk foreign key (an_log_uid) references u_user(u_uid)
);

drop sequence an_log_seq;
create sequence an_log_seq;

drop table notice_log;
create table notice_log(
  n_log_num number not null primary key,
  n_log_uid varchar2(20) not null,
  n_log_reg_date date not null,
  n_log_change number not null,
  n_log_message varchar2(100) not null,
  
  constraint notice_log_fk foreign key (n_log_uid) references u_user(u_uid)
);

drop sequence n_log_seq;
create sequence n_log_seq;

drop table event_log;
create table event_log(
  e_log_num number not null primary key,
  e_log_uid varchar2(20) not null,
  e_log_reg_date date not null,
  e_log_change number not null,
  e_log_message varchar2(100) not null,
  
  constraint evnet_log_fk foreign key (e_log_uid) references u_user(u_uid)
);

drop sequence e_log_seq;
create sequence e_log_seq;

drop table qna_log;
create table qna_log(
  qa_log_num number not null primary key,
  qa_log_uid varchar2(20) not null,
  qa_log_reg_date date not null,
  qa_log_change number not null,
  qa_log_message varchar2(100) not null,
  qa_num number not null,
  
  constraint qna_log_fk foreign key (qa_log_uid) references u_user(u_uid),
  constraint qna_log_fk2 foreign key (qa_num) references qna(qa_num)
);

drop sequence qa_log_seq;
create sequence qa_log_seq;


