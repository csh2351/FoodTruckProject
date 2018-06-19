package customerNotice.model.vo;



public class Notice {
	private int noticePk;
	private String noticeTitle;
	private String noticeDate;
	private String noticeContent;
	
	public Notice() {}

	public Notice(int noticePk, String noticeTitle, String noticeDate, String noticeContent) {
		super();
		this.noticePk = noticePk;
		this.noticeTitle = noticeTitle;
		this.noticeDate = noticeDate;
		this.noticeContent = noticeContent;
	}

	public Notice(String noticeTitle, String noticeDate, String noticeContent) {
		super();
		this.noticeTitle = noticeTitle;
		this.noticeDate = noticeDate;
		this.noticeContent = noticeContent;
	}

	public int getNoticePk() {
		return noticePk;
	}

	public void setNoticePk(int noticePk) {
		this.noticePk = noticePk;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public String getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	@Override
	public String toString() {
		return "Notice [noticePk=" + noticePk + ", noticeTitle=" + noticeTitle + ", noticeDate=" + noticeDate
				+ ", noticeContent=" + noticeContent + "]";
	}
	
	
	
}
