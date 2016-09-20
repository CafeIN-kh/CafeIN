package kr.cafein.admin.qna.service;

import java.util.List;


import org.springframework.transaction.annotation.Transactional;

import kr.cafein.admin.qna.domain.QnaCommand;

@Transactional
public interface QnaService {
	public List<QnaCommand> getQaList();
	public void delete(Integer seq);
	public QnaCommand selectQna(Integer seq);
	public void updateQnaAnswer(Integer seq);
}
