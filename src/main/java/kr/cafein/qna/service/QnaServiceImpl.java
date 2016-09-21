package kr.cafein.qna.service;



import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import kr.cafein.qna.dao.QnaMapper;
import kr.cafein.qna.domain.QnaCommand;

@Service("qnaService")
public class QnaServiceImpl implements QnaService {
	@Resource
	private QnaMapper qnaMapper;
	@Override
	public void insert(QnaCommand qna) {
		// TODO Auto-generated method stub
		qnaMapper.insert(qna);
		
	}

	

	
	
	

}
