package kr.cafein.admin.qna.service;

import java.util.List;


import org.springframework.transaction.annotation.Transactional;

import kr.cafein.admin.qna.domain.AdminQnaCommand;

@Transactional
public interface AdminQnaService {
	public List<AdminQnaCommand> getQaList();
	public void delete(Integer seq);
	public AdminQnaCommand selectQna(Integer seq);
	public void updateQnaAnswer(Integer seq);
}
