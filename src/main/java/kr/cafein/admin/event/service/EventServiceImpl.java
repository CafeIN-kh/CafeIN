package kr.cafein.admin.event.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.cafein.admin.event.dao.EventMapper;
import kr.cafein.admin.event.domain.EventCommand;

@Service("eventService")
public class EventServiceImpl implements EventService {
	
	@Resource
	private EventMapper eventMapper;

	@Override
	public List<EventCommand> getEventList() {
		return eventMapper.getEventList();
	}

	@Override
	public void updateEvent(EventCommand eventCommand) {
		eventMapper.updateEvent(eventCommand);
		
	}

	@Override
	public EventCommand selectEvent(Integer seq) {
		return eventMapper.selectEvent(seq);
	}

	@Override
	public void deletEvente(Integer seq) {
		eventMapper.deletEvente(seq);
		
	}

	@Override
	public void insertEvent(EventCommand eventCommand) {
		eventMapper.insertEvent(eventCommand);
	}

}
