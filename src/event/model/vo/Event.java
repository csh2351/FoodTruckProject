package event.model.vo;

import java.sql.Date;

public class Event {
	   private int eventPk;
	   private String eventTitle;
	   private Date    eventDate;
	   private String eventContent;
	   private String originalFileName;
	   private String renameFileName;
	   private Date eventEndDate;
	   private int truckPk;
	
	
	public Event() {
		super();		
	}


	public Event(int eventPk, String eventTitle, Date eventDate, String eventContent, String originalFileName,
			String renameFileName, Date eventEndDate, int truckPk) {
		super();
		this.eventPk = eventPk;
		this.eventTitle = eventTitle;
		this.eventDate = eventDate;
		this.eventContent = eventContent;
		this.originalFileName = originalFileName;
		this.renameFileName = renameFileName;
		this.eventEndDate = eventEndDate;
		this.truckPk = truckPk;
	}


	@Override
	public String toString() {
		return "Event [eventPk=" + eventPk + ", eventTitle=" + eventTitle + ", eventDate=" + eventDate
				+ ", eventContent=" + eventContent + ", originalFileName=" + originalFileName + ", renameFileName="
				+ renameFileName + ", eventEndDate=" + eventEndDate + ", truckPk=" + truckPk + "]";
	}


	public int getEventPk() {
		return eventPk;
	}


	public void setEventPk(int eventPk) {
		this.eventPk = eventPk;
	}


	public String getEventTitle() {
		return eventTitle;
	}


	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}


	public Date getEventDate() {
		return eventDate;
	}


	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}


	public String getEventContent() {
		return eventContent;
	}


	public void setEventContent(String eventContent) {
		this.eventContent = eventContent;
	}


	public String getOriginalFileName() {
		return originalFileName;
	}


	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}


	public String getRenameFileName() {
		return renameFileName;
	}


	public void setRenameFileName(String renameFileName) {
		this.renameFileName = renameFileName;
	}


	public Date getEventEndDate() {
		return eventEndDate;
	}


	public void setEventEndDate(Date eventEndDate) {
		this.eventEndDate = eventEndDate;
	}


	public int getTruckPk() {
		return truckPk;
	}


	public void setTruckPk(int truckPk) {
		this.truckPk = truckPk;
	}


	
}
