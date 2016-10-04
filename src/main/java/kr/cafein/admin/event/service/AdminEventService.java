package kr.cafein.admin.event.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import kr.cafein.admin.event.domain.AdminEventCommand;
import kr.cafein.admin.event.domain.AdminEventLogCommand;

@Transactional
public interface AdminEventService {
	public List<AdminEventCommand> getEventList();
	public void updateEvent(AdminEventCommand eventCommand);
	public AdminEventCommand selectEvent(Integer seq);
	public void deletEvente(Integer seq);
	public void insertEvent(AdminEventCommand eventCommand);
	public List<AdminEventLogCommand> getAdminEvent_LogList();
	public void insertAdminEvent_Log(AdminEventLogCommand adminevnetLogCommand);
	
}
