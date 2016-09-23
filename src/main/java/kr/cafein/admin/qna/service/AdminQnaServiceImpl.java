package kr.cafein.admin.qna.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.cafein.admin.qna.dao.AdminQnaMapper;
import kr.cafein.admin.qna.domain.AdminQnaCommand;

@Service("adminQnaService")
public class AdminQnaServiceImpl implements AdminQnaService{
	
	@Resource
	private AdminQnaMapper adminQnaMapper;

	@Override
	public List<AdminQnaCommand> getQaList() {
		return adminQnaMapper.getQaList();
		
	}
	
	@Override
	public void delete(Integer seq) {
		adminQnaMapper.delete(seq);
	}

	@Override
	public AdminQnaCommand selectQna(Integer seq) {
		return adminQnaMapper.selectQna(seq);
	}

	@Override
	public void updateQnaAnswer(Integer seq) {
		adminQnaMapper.updateQnaAnswer(seq);
		
	}

}
