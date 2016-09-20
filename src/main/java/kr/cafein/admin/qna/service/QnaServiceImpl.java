package kr.cafein.admin.qna.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.cafein.admin.qna.dao.QnaMapper;
import kr.cafein.admin.qna.domain.QnaCommand;

@Service("qnaService")
public class QnaServiceImpl implements QnaService{
	
	@Resource
	private QnaMapper qnaMapper;

	@Override
	public List<QnaCommand> getQaList() {
		return qnaMapper.getQaList();
		
	}
	
	@Override
	public void delete(Integer seq) {
		qnaMapper.delete(seq);
	}

	@Override
	public QnaCommand selectQna(Integer seq) {
		return qnaMapper.selectQna(seq);
	}

	@Override
	public void updateQnaAnswer(Integer seq) {
		qnaMapper.updateQnaAnswer(seq);
		
	}

}
