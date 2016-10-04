package kr.cafein.admin.event.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.cafein.admin.event.dao.AdminEventMapper;
import kr.cafein.admin.event.domain.AdminEventCommand;
import kr.cafein.admin.event.domain.AdminEventLogCommand;

@Service("adminEventService")
public class AdminEventServiceImpl implements AdminEventService {
	
	@Resource
	private AdminEventMapper adminEventMapper;

	@Override
	public List<AdminEventCommand> getEventList() {
		return adminEventMapper.getEventList();
	}

	@Override
	public void updateEvent(AdminEventCommand eventCommand) {
		adminEventMapper.updateEvent(eventCommand);
		
	}

	@Override
	public AdminEventCommand selectEvent(Integer seq) {
		return adminEventMapper.selectEvent(seq);
	}

	@Override
	public void deletEvente(Integer seq) {
		adminEventMapper.deletEvente(seq);
		
	}

	@Override
	public void insertEvent(AdminEventCommand eventCommand) {
		adminEventMapper.insertEvent(eventCommand);
	}

	@Override
	public List<AdminEventLogCommand> getAdminEvent_LogList() {
		return adminEventMapper.getAdminEvent_LogList();
	}

	@Override
	public void insertAdminEvent_Log(AdminEventLogCommand adminevnetLogCommand) {
		adminEventMapper.insertAdminEvent_Log(adminevnetLogCommand);
		
	}

}
