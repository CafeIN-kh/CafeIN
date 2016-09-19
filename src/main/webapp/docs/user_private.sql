create table u_user (
  u_uid varchar2(20) not null primary key,
  u_email varchar2(50) not null,
  u_name varchar2(15) not null,
  u_password varchar2(15) not null,
  u_reg_date date not null,
  u_level number default 0
);

create sequence user_seq;

create table private_cafe(
  pcafe_num number not null primary key,
  u_uid varchar2(20) not null,
  pcafe_name varchar2(30) not null,
  pcafe_address varchar2(100),
  pcafe_phone varchar2(30),
  pcafe_time varchar2(100),
  pcafe_url varchar2(50),
  pcafe_introduce varchar2(4000),
  pcafe_hash_tag varchar2(500),
  pcafe_img varchar2(2000) not null,
  pcafe_visit number default 0,
  pcafe_reg_date date not null
);

create sequence private_cafe_seq;

create table private_cafe_menu(
	pmenu_num number not null primary key,
	pcafe_num number not null,
	pmenu_name varchar2(50) not null,
	pmenu_price number default 0,
	pmenu_introduce varchar2(4000),
	pmenu_img varchar2(100) not null
);

create sequence private_cafe_menu_seq;

create table private_cafe_reply(
	preply_num number not null primary key,
	pcafe_num number not null,
	u_uid varchar2(20) not null,
	preply_content varchar2(500),
	preply_nickname varchar2(15) not null,
	preply_reg_date date not null
);

create sequence private_cafe_reply_seq;

/* u_like 테이블  - 좋아요 누른 유저 목록 정보*/
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

create sequence u_like_seq;

/* bookmark 테이블 - 즐겨찾기*/
create table bookmark(
   bookmark_num number not null,
   u_uid varchar2(20) not null,
   franchise_num number,
   pcafe_num number,
   custom_num number,
   bookmark_reg_date date not null,
   constraint bookmark_pk primary key (bookmark_num)
);

create sequence bookmark_seq;

		


==========================아래는 실행 안시켜도 됨========================
drop table u_user;
drop table private_cafe;
drop table private_cafe_menu;
drop table private_cafe_reply;
drop table u_like;
drop table bookmark;

drop sequence user_seq;
drop sequence private_cafe_seq;
drop sequence private_cafe_menu_seq;
drop sequence private_cafe_reply_seq;
drop sequence u_like_seq;
drop sequence bookmark_seq;



select * from (select a.*, rownum rnum from
                (select pcafe.pcafe_num, count(pc_reply.pcafe_num) pc_reply_cnt, count(pc_like.pcafe_num) pc_like_cnt from private_cafe pcafe 
                  left join (select * from private_cafe_reply )pc_reply 
                  on pcafe.pcafe_num = pc_reply.pcafe_num  
                  left join (select  * from u_like ) pc_like
                  on pcafe.pcafe_num = pc_like.pcafe_num
                  group by pcafe.pcafe_num 
                order by pcafe.pcafe_num desc)a) 
			where rnum >= 1 and rnum <= 26;
			
			
select * from (select a.*, rownum rnum from
                (select * from private_cafe pcafe 
                  left join (select pcafe_num, count(*) pc_reply_cnt from private_cafe_reply group by pcafe_num)pc_reply 
                  on pcafe.pcafe_num = pc_reply.pcafe_num  
                  left join (select pcafe_num, count(*) pc_like_cnt from u_like group by pcafe_num) pc_like
                  on pcafe.pcafe_num = pc_like.pcafe_num
                order by pcafe.pcafe_reg_date desc)a) 
			where rnum >= 1 and rnum <= 26;

			
	SELECT 
	*
	FROM (SELECT 
	  			a.*, 
	  			rownum rnum 
	  		FROM (SELECT pcafe.*, 
	  					 pc_reply.pc_reply_cnt, 
	  					 pc_like.pc_like_cnt
	  				FROM private_cafe pcafe 
	                  	LEFT JOIN (SELECT pcafe_num, count(*) pc_reply_cnt 
	                  				FROM private_cafe_reply 
	                  				GROUP BY pcafe_num)pc_reply 
	                  	ON pcafe.pcafe_num = pc_reply.pcafe_num  
                  		LEFT JOIN (SELECT pcafe_num, count(*) pc_like_cnt 
                  					FROM u_like 
                  					GROUP BY pcafe_num) pc_like
                 		ON pcafe.pcafe_num = pc_like.pcafe_num
            	ORDER BY pcafe.pcafe_reg_date DESC)a)
	WHERE rnum >= 1 and rnum <= 26;
	
	
	