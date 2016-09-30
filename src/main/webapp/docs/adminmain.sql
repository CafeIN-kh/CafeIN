insert into user_count_log(ucnt_log_seq,ucnt_log_reg_date,ucnt_total,ucnt_log_main,ucnt_log_franchise,ucnt_log_private,ucnt_log_custom,ucnt_log_qna,ucnt_log_notice) 
values(user_count_log_seq.nextval,sysdate-5,2340,abs(rpad(dbms_random.random,4)),abs(rpad(dbms_random.random,4)),abs(rpad(dbms_random.random,4)),abs(rpad(dbms_random.random,4)),abs(rpad(dbms_random.random,4)),abs(rpad(dbms_random.random,4)));




create table admin_notice(
  admin_notice_num number default 0,
  admin_notice_title varchar2(100) not null,
  admin_notice_content varchar2(500) not null,
  admin_notice_reg_date date not null,
  admin_notice_hit number default 0,
  admin_notice_img varchar2(2000),
  constraint admin_notice_pk primary key(admin_notice_num)
);

create sequence admin_notice_seq;



insert into admin_notice(admin_notice_num,admin_notice_title,admin_notice_content,admin_notice_reg_date) values(admin_notice_seq.nextval,'이벤트공지','오늘 이벤트는 어쩌고 저쩌고 그렇고 저렇고 하하하하하하하하하하하하하',sysdate);
insert into admin_notice(admin_notice_num,admin_notice_title,admin_notice_content,admin_notice_reg_date) values(admin_notice_seq.nextval,'알림공지','오늘 알림은 어쩌고 저쩌고 그렇고 저렇고 하하하하하하하하하하하하하',sysdate);
insert into admin_notice(admin_notice_num,admin_notice_title,admin_notice_content,admin_notice_reg_date) values(admin_notice_seq.nextval,'장딜바보공지','오늘 장딜바보 어쩌고 저쩌고 그렇고 저렇고 하하하하하하하하하하하하하',sysdate);
insert into admin_notice(admin_notice_num,admin_notice_title,admin_notice_content,admin_notice_reg_date) values(admin_notice_seq.nextval,'멍청이공지','오늘 멍청이 어쩌고 저쩌고 그렇고 저렇고 하하하하하하하하하하하하하',sysdate);
insert into admin_notice(admin_notice_num,admin_notice_title,admin_notice_content,admin_notice_reg_date) values(admin_notice_seq.nextval,'똥개공지','오늘 똥개 어쩌고 저쩌고 그렇고 저렇고 하하하하하하하하하하하하하',sysdate);
insert into admin_notice(admin_notice_num,admin_notice_title,admin_notice_content,admin_notice_reg_date) values(admin_notice_seq.nextval,'말미잘공지','오늘 말미잘 어쩌고 저쩌고 그렇고 저렇고 하하하하하하하하하하하하하',sysdate);
insert into admin_notice(admin_notice_num,admin_notice_title,admin_notice_content,admin_notice_reg_date) values(admin_notice_seq.nextval,'해삼공지','오늘 해삼 어쩌고 저쩌고 그렇고 저렇고 하하하하하하하하하하하하하',sysdate);