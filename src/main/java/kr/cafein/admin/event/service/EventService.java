package kr.cafein.admin.event.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import kr.cafein.admin.event.domain.EventCommand;

@Transactional
public interface EventService {
	public List<EventCommand> getEventList();
	public void updateEvent(EventCommand eventCommand);
	public EventCommand selectEvent(Integer seq);
	public void deletEvente(Integer seq);
	public void insertEvent(EventCommand eventCommand);
	
}
