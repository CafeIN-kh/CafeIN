package kr.cafein.qna.service;



import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import kr.cafein.domain.UserCountLogCommand;
import kr.cafein.domain.UserMenuLogCommand;
import kr.cafein.qna.dao.QnaMapper;
import kr.cafein.qna.domain.QnaCommand;

@Service("qnaService")
public class QnaServiceImpl implements QnaService {
	@Resource
	private QnaMapper qnaMapper;
	
	@Override
	public void insert(QnaCommand qna) {
		qnaMapper.insert(qna);
	}
	@Override
	public void insertQnAUserCountLog() {
		qnaMapper.insertQnAUserCountLog();
	}
	@Override
	public void updateQnAUserCountLog() {
		qnaMapper.updateQnAUserCountLog();
	}
	@Override
	public UserCountLogCommand selectQnAUserCountLogByDate() {
		return qnaMapper.selectQnAUserCountLogByDate();
	}
	@Override
	public void insertQnaUserLog(UserMenuLogCommand userMenuLog) {
		qnaMapper.insertQnaUserLog(userMenuLog);
	}

}
