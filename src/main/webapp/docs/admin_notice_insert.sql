/* 관리자용 공지사항 insert
 * 해당 이미지 upload 폴더에 넣어놓음  */

insert into admin_notice values(admin_notice_seq.nextval, 'Git Master에 Commit 금지', 'Master 계정에 Commit시 모든 파일이 덮어써지므로 절대로 Master에 Commit하지말고 Branch를 따서 Commit하세요',sysdate-2,2,'an_01.jsp');
insert into admin_notice values(admin_notice_seq.nextval, '신고된 회원 처리사항', '신고된 회원은 검사후 타당한 사유 시 계정 금지 시키세요',sysdate,2,'an_02.jsp');