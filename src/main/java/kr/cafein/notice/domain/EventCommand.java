package kr.cafein.notice.domain;

import java.sql.Date;

public class EventCommand {
	private int event_num;
	private String event_title;
	private String event_content;
	private Date event_reg_date;
	private int event_hit;
	private String event_img;
	
	public int getEvent_num() {
		return event_num;
	}
	public void setEvent_num(int event_num) {
		this.event_num = event_num;
	}
	public String getEvent_title() {
		return event_title;
	}
	public void setEvent_title(String event_title) {
		this.event_title = event_title;
	}
	public String getEvent_content() {
		return event_content;
	}
	public void setEvent_content(String event_content) {
		this.event_content = event_content;
	}
	public Date getEvent_reg_date() {
		return event_reg_date;
	}
	public void setEvent_reg_date(Date event_reg_date) {
		this.event_reg_date = event_reg_date;
	}
	public int getEvent_hit() {
		return event_hit;
	}
	public void setEvent_hit(int event_hit) {
		this.event_hit = event_hit;
	}
	public String getEvent_img() {
		return event_img;
	}
	public void setEvent_img(String event_img) {
		this.event_img = event_img;
	}
	
	@Override
	public String toString() {
		return "EventCommand [event_num=" + event_num + ", event_title=" + event_title + ", event_content="
				+ event_content + ", event_reg_date=" + event_reg_date + ", event_hit=" + event_hit + ", event_img="
				+ event_img + "]";
	}
}
