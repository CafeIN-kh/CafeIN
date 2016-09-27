/**********************************************
 * 
 *  drop, create 같이 있으니 확인하면서 생성하세요 
 * 
 *  insert 부분은 맨 아래에 있음
 *  
 **********************************************/


/* u_user 테이블 - 회원정보 
 * 
 * u_level : 등급(0:일반회원,1:사업자) */
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

/* franchise 테이블 - 프랜차이즈 정보*/
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

/* franchise_menu 테이블 - 프랜차이즈 메뉴 정보*/
drop table franchise_menu;

create table franchise_menu(
   fmenu_num number not null,
   franchise_num number not null,
   fmenu_name varchar2(50) not null,
   fmenu_price number default 0,
   fmenu_img varchar2(100) not null,
   fmenu_introduce varchar(4000),
   constraint franchise_menu_pk primary key (fmenu_num),
   constraint franchise_menu_fk foreign key (franchise_num) references franchise(franchise_num)
);

drop sequence franchise_menu_seq;
create sequence franchise_menu_seq;

/* franchise_reply 테이블 - 프랜차이즈 댓글 정보*/
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

/* private_cafe 테이블 - 개인카페 정보 (사업자만 등록 가능한 정보)*/
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
   constraint private_cafe_pk primary key (pcafe_num),
   constraint private_cafe_fk foreign key (u_uid) references u_user(u_uid)
);

drop sequence private_cafe_seq;
create sequence private_cafe_seq;

/* private_cafe_menu 테이블 - 개인카페 메뉴 정보(사업자만 등록가능한 정보) */
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

/* private_cafe_reply 테이블 - 개인카페 댓글 정보 */
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

/* notice 테이블 - 공지사항 */
drop table notice;

create table notice(
   notice_num number not null ,
   notice_title varchar2(100) not null,
   notice_content varchar2(500) not null,
   notice_reg_date date not null,
   notice_hit number default 0,
   notice_img varchar2(2000),
   constraint notice_pk primary key (notice_num)
);

drop sequence notice_seq;
create sequence notice_seq;

/* event 테이블 - 이벤트 */
drop table event;

create table event(
   event_num number not null primary key,
   event_title varchar2(100) not null,
   event_content varchar2(500) not null,
   event_reg_date date not null,
   event_hit number default(0),
   event_img varchar2(2000)
);

drop sequence event_seq;
create sequence event_seq;

/* Q&A 테이블 - 고객문의, 건의사항 정보 
 * 
 * qa_f_option : 0:프랜차이즈카페문의,1:개인카페문의,2:커스터마이밍문의,3:이벤트문의,4:건의사항 */
drop table QNA;

create table QNA(
   qa_num number not null,
   qa_email varchar2(50) not null,
   qa_title varchar2(100) not null,
   qa_content varchar2(4000) not null,
   qa_password varchar2(15) not null,
   qa_reg_date date not null,
   qa_f_option number default 0,
   constraint QNA_pk primary key (qa_num)
);

drop sequence qna_seq;
create sequence qna_seq;

/* u_like 테이블  - 좋아요 누른 유저 목록 정보*/
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

/* bookmark 테이블 - 즐겨찾기*/
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

/* customizing 테이블 - 커스텀마이징 관리 테이블 */
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
   constraint customizing_fk1 foreign key (franchise_num) references franchis (franchise_num),
   constraint customizing_fk2 foreign key (u_uid) references u_user(u_uid)
);

drop sequence customizing_seq;
create sequence customizing_seq;

/* customizing_reply 테이블 - 커스터마이징 메뉴 댓글 */
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

/* F_log 테이블 - 프랜차이즈 로그
 * 
 * F_log_change : 0[추가] 1[삭제]2[수정]*/
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
   constraint F_log_fk1 foreign key (Brand_code) references franchise(franchise_num),
   constraint F_log_fk2 foreign key (U_uid) references u_user(u_uid)
);

drop sequence F_log_seq;
create sequence F_log_seq;

/* P_log 테이블 - 개인카페 로그
 * 
 * P_log_change : 0[추가] 1[삭제] 2[수정]
 * P_log_controller : 0 [관리자가 변경] 1 [유저가 변경] */
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
   constraint P_log_fk1 foreign key (Pcafe_num) references private_cafe(pcafe_num),
   constraint P_log_fk2 foreign key (U_uid) references u_user(u_uid)
);

drop sequence P_log_seq;
create sequence P_log_seq;

/* declared 테이블 - 게시물 혹은 댓글 신고시 신고한 내역이 저장되는 테이블 
 * 
 * d_target_path : 0[프랜차이즈 댓글] 1[개인카페 댓글] 2[커스터마이징 댓글] */
drop table declared;

create table declared(
   d_seq number(20) not null,
   d_target_path number(20) not null,
   d_target_num number(20) not null,
   d_target_id number(20) not null,
   d_mem_id varchar2(20) not null, 
   d_target_mem_id varchar2(20),
   d_reg_date date not null,
   d_content varchar2(4000),
   d_state number(20) default(0),
   d_comment varchar2(2000),
   constraint declared_pk primary key (d_seq)
);

drop sequence declared_seq;
create sequence declared_seq;

/* mlog 테이블 - 회원관리 로그 테이블
 * 
 * mlog_num : 0-삭제 1-수정 2-기타 */
drop table mlog;

create table mlog(
   mlog_seq number(20) not null, 
   mlog_reg_date date not null,
   mlog_num number(20) not null,
   mlog_processInfo varchar2(20) not null,
   mlog_content varchar2(200) not null,
   target_id varchar2(20) not null,
   constraint mlog_pk primary key (mlog_seq),
   constraint mlog_fk foreign key (target_id) references u_user(u_uid)
);

drop sequence mlog_seq;
create sequence mlog_seq;

/* nlog 테이블 - 공지사항 로그 테이블 */
drop table nlog;

create table nlog(
   nlog_seq number(20) not null,
   nlog_reg_date date not null,
   nlog_num number(20) not null,
   nlog_processInfo varchar2(20) not null,
   nlog_content varchar2(200) not null,
   constraint nlog_pk primary key (nlog_seq)
);

drop sequence nlog_seq;
create sequence nlog_seq;

/*user_log - 회원 로그 테이블 */
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

/*user_count_log 메뉴에 따른 페이지뷰 카운트 로그 테이블*/

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
 * user_menu_log 메뉴의 상태 로그 테이블
 * umenu_name : 0[개인카페] 1[커스텀메뉴] 2[프랜차이즈 댓글] 3[개인카페 댓글] 4[커스텀 댓글]
 * umenu_log_state : 0[등록] 1[수정] 2[삭제] 3[신고]
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

/* 관리자용 공지사항 테이블 */
drop table admin_notice;

create table admin_notice(
	admin_notice_num number not null,
	admin_notice_title varchar2(100) not null,
	admin_notice_content varchar2(500) not null,
	admin_notice_reg_date date not null,
	admin_notice_hit number default(0),
	admin_notice_img varchar2(2000) not null,
	constraint admin_notice primary key (admin_notice_num)
);

drop sequence admin_notice_num_seq;
create sequence admin_notice_num_seq;

/*프랜차이즈*/
INSERT INTO franchise VALUES(1,'스타벅스','star.jpg','프랜차이즈 브랜드의 대표적인 브랜드이다', '10');
INSERT INTO franchise VALUES(2,'할리스','hollys.jpg','할리스 원두는 맛있다', '15');
INSERT INTO franchise VALUES(3,'커피빈','coffeebean.jpg','와이파이 없는 곳','');
INSERT INTO franchise VALUES(4,'이디야','ediya.jpg','저려미', '5');
INSERT INTO franchise VALUES(5,'투썸','twosome.jpg','진한 커피', '3');

/*사용자*/
INSERT INTO u_user VALUES('aaa','aaa@test.com','에이','12345','2016-09-01','');
INSERT INTO u_user VALUES('bbb','bbb@test.com','비','56789','2016-08-01','1');
INSERT INTO u_user VALUES('ccc','ccc@test.com','씨','55555','2016-08-31','1');
INSERT INTO u_user VALUES('ddd','ddd@test.com','디','33333','2016-08-21','');
INSERT INTO u_user VALUES('eee','eee@test.com','이','11111','2016-09-01','');


/*개인카페*/
INSERT INTO private_cafe VALUES(1,'bbb','아모르미오','서울시 관악구','010-0000-0000','AM9:00~PM10:00','htt://www.daum.net','가을의 분위기를 느낄수 있습니다.','가을,분위기','coffee.jpg',5,'2016-09-01');
INSERT INTO private_cafe VALUES(5,'ccc','가나다커피','서울시 마포구','010-1234-0000','AM10:00~PM10:00','htt://www.rkakek.com','아기자기한 카페.','아기자기,귀여움','rkskek.jpg',13,'2016-09-02');
INSERT INTO private_cafe VALUES(3,'eee','21second','서울시 종로구','010-2121-2121','AM11:00~PM9:00','htt://www.21second.net','최상의 원두를 느낄수있는 커피.','원두,고품질,전문추출','21second.jpg',23,'2016-09-03');

/*즐겨찾기*/
INSERT INTO bookmark VALUES(1,'aaa',1,1,1);
INSERT INTO bookmark VALUES(2,'bbb',1,5,1);
INSERT INTO bookmark VALUES(3,'ccc',2,5,1);
INSERT INTO bookmark VALUES(4,'ddd',2,3,2);
INSERT INTO bookmark VALUES(5,'eee',2,3,2);
INSERT INTO bookmark VALUES(6,'aaa',3,3,3);

/*커스텀*/
INSERT INTO customizing VALUES(1,1,'aaa','악마의 음료','그린티 프라푸치노와 간 자바칩, 샷 등을 넣어 만든 커스텀 메뉴로 그린트와 초코의 맛을 느낄 수 있다','그린티프라푸치노와 자바칩을 갈고 그 위에 샷을 붓는다. 위에 휘핑을 올리고 통 자바칩과 초코드리즐을 올린다.','customGreentea.jpg','그린티,자바칩,샷,초코,드리즐',55,'2016-09-01');
INSERT INTO customizing VALUES(2,1,'bbb','돼지바 프라프치노','돼지바 아이스크림과 같은 맛을 느낄 수 있다','딸기시럽 2펌프 넣고 자바칩 갈고 휘핑과 초코 드리즐을 추가한다','customPigbar.jpg','딸기시럽,자바칩,휘핑,초코,드리즐',21,'2016-08-30');
INSERT INTO customizing VALUES(3,1,'ccc','트윅스 프라프치노','트윅스 같은 맛을 느낄 수 있다','카라멜프라푸치노에 헤이즐넛시럽 한펌프와 자바칩을 넣고 휘핑과 통자바, 초코드리즐, 카라멜드리즐을 더 추가한다.','customTwix.jpg','카라멜,헤이즐넛,자바칩,초코,드리즐',33,'2016-09-02');
INSERT INTO customizing VALUES(4,2,'aaa','아몬드 크림라떼','아몬드와 크림의 고소함을 느낄 수 있다.','아몬드 우유를 선택하고 리스트레또샷을 선택하고 휩을 추가한다.','customAlmond.jpg','아몬드,리스트레또,샷',17,'2016-09-03');
INSERT INTO customizing VALUES(5,3,'eee','체리쥬빌레','체리쥬빌레 아이스크립과 같은 맛을 느낄 수 있다.','바닐라 블렌디드에 엑스트라 체리를 추가한다','customCherry.jpg','바닐라,체리',13,'2016-09-03');

/*좋아요*/
INSERT INTO u_like VALUES(1,'aaa',1,1,1,1,1);
INSERT INTO u_like VALUES(2,'aaa',1,3,4,2,2);
INSERT INTO u_like VALUES(3,'aaa',2,1,1,3,3);
INSERT INTO u_like VALUES(4,'aaa',2,5,3,4,4);
INSERT INTO u_like VALUES(5,'aaa',2,5,1,5,5);
INSERT INTO u_like VALUES(6,'bbb',3,5,1,5,4);
INSERT INTO u_like VALUES(7,'bbb',3,1,1,5,5);
INSERT INTO u_like VALUES(8,'eee',2,5,2,5,5);
INSERT INTO u_like VALUES(9,'eee',4,5,2,3,4);
INSERT INTO u_like VALUES(10,'eee',5,3,2,5,5);
INSERT INTO u_like VALUES(11,'ddd',5,2,4,5,3);
INSERT INTO u_like VALUES(12,'ddd',5,4,2,5,4);
INSERT INTO u_like VALUES(13,'ddd',5,5,5,5,5);
INSERT INTO u_like VALUES(14,'ddd',5,5,4,5,5);
INSERT INTO u_like VALUES(15,'ddd',1,2,3,1,1);
INSERT INTO u_like VALUES(16,'aaa',1,1,3,1,1);
INSERT INTO u_like VALUES(17,'aaa',1,3,3,1,4);
INSERT INTO u_like VALUES(18,'aaa',1,5,3,1,3);
INSERT INTO u_like VALUES(19,'bbb',1,1,3,3,1);
INSERT INTO u_like VALUES(20,'bbb',5,1,3,2,2);

/*개인카페 메뉴*/
select * from private_cafe_menu;  
INSERT INTO private_cafe_menu VALUES(1,1,'아메리카노','5800','항아리 잔에 나오는 독특한 커피','dkahfm.jpg');
INSERT INTO private_cafe_menu VALUES(2,1,'카라멜초코 라떼','6300','라떼위에 카라멜 소스와 초콜릿 토핑을 올린 라떼','amormio.jpg');
INSERT INTO private_cafe_menu VALUES(3,5,'자몽에이드','7000','자몽 토핑과 스파클링의 조화가 느껴지는 에이드','rkskekcoffee.jpg');
INSERT INTO private_cafe_menu VALUES(4,3,'카라멜마끼아또','5500','바닐라 시럽과 카라멜 소스와 조화되는 라떼','21secondcoffee.jpg');

/*프랜차이즈 메뉴*/
select * from franchise_menu;
INSERT INTO franchise_menu VALUES (1,5,'콜드브루','5500','twocold.jpg','원두가루를 냉침하여 우려낸 커피로 부드럽다');
INSERT INTO franchise_menu VALUES (2,5,'로얄밀크티','6500','twoearlgrey.jpg','얼그레이티백을 따뜻한 우유로 우려낸 부드러운 밀크티');
INSERT INTO franchise_menu VALUES (3,1,'아메리카노','4500','starame.jpg','스타벅스만의 원두로 진한고 깊이있는 아메리카노');
INSERT INTO franchise_menu VALUES (4,2,'청포도스파클링','6000','hollysspa.jpg','청포도 퓨레와 스파클링의 조화로 달달하고 똑 쏘는 재미있는 음료');


