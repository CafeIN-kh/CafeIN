/* 통계 띄우기 위해 임의로 넣은 페이지 카운트수
 * 혹시라도 사이트 방문하면서 user_count_log 테이블에 데이터가 쌓였다면 전부 delete 시키고 이 아래 insert 시키기.
 * 디비 꼬여서 사이트 메인에서 오류남 */

insert into user_count_log(ucnt_log_seq,ucnt_log_reg_date,ucnt_total,ucnt_log_main,ucnt_log_franchise,ucnt_log_private,ucnt_log_custom,ucnt_log_qna,ucnt_log_notice) 
values(user_count_log_seq.nextval,sysdate,2340,abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)));

insert into user_count_log(ucnt_log_seq,ucnt_log_reg_date,ucnt_total,ucnt_log_main,ucnt_log_franchise,ucnt_log_private,ucnt_log_custom,ucnt_log_qna,ucnt_log_notice) 
values(user_count_log_seq.nextval,sysdate-1,2340,abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)));

insert into user_count_log(ucnt_log_seq,ucnt_log_reg_date,ucnt_total,ucnt_log_main,ucnt_log_franchise,ucnt_log_private,ucnt_log_custom,ucnt_log_qna,ucnt_log_notice) 
values(user_count_log_seq.nextval,sysdate-2,2340,abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)));

insert into user_count_log(ucnt_log_seq,ucnt_log_reg_date,ucnt_total,ucnt_log_main,ucnt_log_franchise,ucnt_log_private,ucnt_log_custom,ucnt_log_qna,ucnt_log_notice) 
values(user_count_log_seq.nextval,sysdate-3,2340,abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)));


insert into user_count_log(ucnt_log_seq,ucnt_log_reg_date,ucnt_total,ucnt_log_main,ucnt_log_franchise,ucnt_log_private,ucnt_log_custom,ucnt_log_qna,ucnt_log_notice) 
values(user_count_log_seq.nextval,sysdate-4,2340,abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)));

insert into user_count_log(ucnt_log_seq,ucnt_log_reg_date,ucnt_total,ucnt_log_main,ucnt_log_franchise,ucnt_log_private,ucnt_log_custom,ucnt_log_qna,ucnt_log_notice) 
values(user_count_log_seq.nextval,sysdate-5,2340,abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)));

insert into user_count_log(ucnt_log_seq,ucnt_log_reg_date,ucnt_total,ucnt_log_main,ucnt_log_franchise,ucnt_log_private,ucnt_log_custom,ucnt_log_qna,ucnt_log_notice) 
values(user_count_log_seq.nextval,sysdate-6,2340,abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)));

insert into user_count_log(ucnt_log_seq,ucnt_log_reg_date,ucnt_total,ucnt_log_main,ucnt_log_franchise,ucnt_log_private,ucnt_log_custom,ucnt_log_qna,ucnt_log_notice) 
values(user_count_log_seq.nextval,sysdate-7,2340,abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)));

insert into user_count_log(ucnt_log_seq,ucnt_log_reg_date,ucnt_total,ucnt_log_main,ucnt_log_franchise,ucnt_log_private,ucnt_log_custom,ucnt_log_qna,ucnt_log_notice) 
values(user_count_log_seq.nextval,sysdate-8,2340,abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)));

insert into user_count_log(ucnt_log_seq,ucnt_log_reg_date,ucnt_total,ucnt_log_main,ucnt_log_franchise,ucnt_log_private,ucnt_log_custom,ucnt_log_qna,ucnt_log_notice) 
values(user_count_log_seq.nextval,sysdate-9,2340,abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)));


insert into user_count_log(ucnt_log_seq,ucnt_log_reg_date,ucnt_total,ucnt_log_main,ucnt_log_franchise,ucnt_log_private,ucnt_log_custom,ucnt_log_qna,ucnt_log_notice) 
values(user_count_log_seq.nextval,sysdate-10,2340,abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)));

insert into user_count_log(ucnt_log_seq,ucnt_log_reg_date,ucnt_total,ucnt_log_main,ucnt_log_franchise,ucnt_log_private,ucnt_log_custom,ucnt_log_qna,ucnt_log_notice) 
values(user_count_log_seq.nextval,sysdate-11,2340,abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)));

insert into user_count_log(ucnt_log_seq,ucnt_log_reg_date,ucnt_total,ucnt_log_main,ucnt_log_franchise,ucnt_log_private,ucnt_log_custom,ucnt_log_qna,ucnt_log_notice) 
values(user_count_log_seq.nextval,sysdate-12,2340,abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)));

insert into user_count_log(ucnt_log_seq,ucnt_log_reg_date,ucnt_total,ucnt_log_main,ucnt_log_franchise,ucnt_log_private,ucnt_log_custom,ucnt_log_qna,ucnt_log_notice) 
values(user_count_log_seq.nextval,sysdate-13,2340,abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)));

insert into user_count_log(ucnt_log_seq,ucnt_log_reg_date,ucnt_total,ucnt_log_main,ucnt_log_franchise,ucnt_log_private,ucnt_log_custom,ucnt_log_qna,ucnt_log_notice) 
values(user_count_log_seq.nextval,sysdate-14,2340,abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)));

insert into user_count_log(ucnt_log_seq,ucnt_log_reg_date,ucnt_total,ucnt_log_main,ucnt_log_franchise,ucnt_log_private,ucnt_log_custom,ucnt_log_qna,ucnt_log_notice) 
values(user_count_log_seq.nextval,sysdate-15,2340,abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)));

insert into user_count_log(ucnt_log_seq,ucnt_log_reg_date,ucnt_total,ucnt_log_main,ucnt_log_franchise,ucnt_log_private,ucnt_log_custom,ucnt_log_qna,ucnt_log_notice) 
values(user_count_log_seq.nextval,sysdate-16,2340,abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)));

insert into user_count_log(ucnt_log_seq,ucnt_log_reg_date,ucnt_total,ucnt_log_main,ucnt_log_franchise,ucnt_log_private,ucnt_log_custom,ucnt_log_qna,ucnt_log_notice) 
values(user_count_log_seq.nextval,sysdate-17,2340,abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)));

insert into user_count_log(ucnt_log_seq,ucnt_log_reg_date,ucnt_total,ucnt_log_main,ucnt_log_franchise,ucnt_log_private,ucnt_log_custom,ucnt_log_qna,ucnt_log_notice) 
values(user_count_log_seq.nextval,sysdate-18,2340,abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)));

insert into user_count_log(ucnt_log_seq,ucnt_log_reg_date,ucnt_total,ucnt_log_main,ucnt_log_franchise,ucnt_log_private,ucnt_log_custom,ucnt_log_qna,ucnt_log_notice) 
values(user_count_log_seq.nextval,sysdate-19,2340,abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)));

insert into user_count_log(ucnt_log_seq,ucnt_log_reg_date,ucnt_total,ucnt_log_main,ucnt_log_franchise,ucnt_log_private,ucnt_log_custom,ucnt_log_qna,ucnt_log_notice) 
values(user_count_log_seq.nextval,sysdate-20,2340,abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)));

insert into user_count_log(ucnt_log_seq,ucnt_log_reg_date,ucnt_total,ucnt_log_main,ucnt_log_franchise,ucnt_log_private,ucnt_log_custom,ucnt_log_qna,ucnt_log_notice) 
values(user_count_log_seq.nextval,sysdate-21,2340,abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)));

insert into user_count_log(ucnt_log_seq,ucnt_log_reg_date,ucnt_total,ucnt_log_main,ucnt_log_franchise,ucnt_log_private,ucnt_log_custom,ucnt_log_qna,ucnt_log_notice) 
values(user_count_log_seq.nextval,sysdate-22,2340,abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)));

insert into user_count_log(ucnt_log_seq,ucnt_log_reg_date,ucnt_total,ucnt_log_main,ucnt_log_franchise,ucnt_log_private,ucnt_log_custom,ucnt_log_qna,ucnt_log_notice) 
values(user_count_log_seq.nextval,sysdate-23,2340,abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)));

insert into user_count_log(ucnt_log_seq,ucnt_log_reg_date,ucnt_total,ucnt_log_main,ucnt_log_franchise,ucnt_log_private,ucnt_log_custom,ucnt_log_qna,ucnt_log_notice) 
values(user_count_log_seq.nextval,sysdate-24,2340,abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)));

insert into user_count_log(ucnt_log_seq,ucnt_log_reg_date,ucnt_total,ucnt_log_main,ucnt_log_franchise,ucnt_log_private,ucnt_log_custom,ucnt_log_qna,ucnt_log_notice) 
values(user_count_log_seq.nextval,sysdate-25,2340,abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)));

insert into user_count_log(ucnt_log_seq,ucnt_log_reg_date,ucnt_total,ucnt_log_main,ucnt_log_franchise,ucnt_log_private,ucnt_log_custom,ucnt_log_qna,ucnt_log_notice) 
values(user_count_log_seq.nextval,sysdate-26,2340,abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)));

insert into user_count_log(ucnt_log_seq,ucnt_log_reg_date,ucnt_total,ucnt_log_main,ucnt_log_franchise,ucnt_log_private,ucnt_log_custom,ucnt_log_qna,ucnt_log_notice) 
values(user_count_log_seq.nextval,sysdate-27,2340,abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)));

insert into user_count_log(ucnt_log_seq,ucnt_log_reg_date,ucnt_total,ucnt_log_main,ucnt_log_franchise,ucnt_log_private,ucnt_log_custom,ucnt_log_qna,ucnt_log_notice) 
values(user_count_log_seq.nextval,sysdate-28,2340,abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)));

insert into user_count_log(ucnt_log_seq,ucnt_log_reg_date,ucnt_total,ucnt_log_main,ucnt_log_franchise,ucnt_log_private,ucnt_log_custom,ucnt_log_qna,ucnt_log_notice) 
values(user_count_log_seq.nextval,sysdate-29,2340,abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)));

insert into user_count_log(ucnt_log_seq,ucnt_log_reg_date,ucnt_total,ucnt_log_main,ucnt_log_franchise,ucnt_log_private,ucnt_log_custom,ucnt_log_qna,ucnt_log_notice) 
values(user_count_log_seq.nextval,sysdate-30,2340,abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)),abs(rpad(dbms_random.random,3)));