package event.model.vo;

import java.sql.Date;

public class Event {

	private int eventPk;
	private String eventTitle;
	private String eventImg;
	private Date eventDate;
	private String eventContent;
	private String originalFileName;
	private String renameFileName;
	private int truckPk;
	private String truckEvent;
	
	public Event() {
		super();		
	}

	public Event(int eventPk, String eventTitle, String eventImg, Date eventDate, String eventContent,
			String originalFileName, String renameFileName, int truckPk, String truckEvent) {
		super();
		this.eventPk = eventPk;
		this.eventTitle = eventTitle;
		this.eventImg = eventImg;
		this.eventDate = eventDate;
		this.eventContent = eventContent;
		this.originalFileName = originalFileName;
		this.renameFileName = renameFileName;
		this.truckPk = truckPk;
		this.truckEvent = truckEvent;
	}

	@Override
	public String toString() {
		return "Event [eventPk=" + eventPk + ", eventTitle=" + eventTitle + ", eventImg=" + eventImg + ", eventDate="
				+ eventDate + ", eventContent=" + eventContent + ", originalFileName=" + originalFileName
				+ ", renameFileName=" + renameFileName + ", truckPk=" + truckPk + ", truckEvent=" + truckEvent + "]";
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

	public String getEventImg() {
		return eventImg;
	}

	public void setEventImg(String eventImg) {
		this.eventImg = eventImg;
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

	public int getTruckPk() {
		return truckPk;
	}

	public void setTruckPk(int truckPk) {
		this.truckPk = truckPk;
	}

	public String getTruckEvent() {
		return truckEvent;
	}

	public void setTruckEvent(String truckEvent) {
		this.truckEvent = truckEvent;
	}
	
	
	
}
