package mypageQuestion.model.vo;

import java.sql.Date;

public class Qna {
	private int qnaPk;
	private String qnaTitle;
	private String answerTitle;
	private String answerContent;
	private String qnaContent;
	private String qnaWriter;
	private String qnaDate;
	private String qnaAnswerDate;
	private String qnaAnswerCheck;
	
	public Qna() {
		
	}

	public Qna(int qnaPk, String qnaTitle, String answerTitle, String answerContent, String qnaContent,
			String qnaWriter, String qnaDate, String qnaAnswerDate, String qnaAnswerCheck) {
		super();
		this.qnaPk = qnaPk;
		this.qnaTitle = qnaTitle;
		this.answerTitle = answerTitle;
		this.answerContent = answerContent;
		this.qnaContent = qnaContent;
		this.qnaWriter = qnaWriter;
		this.qnaDate = qnaDate;
		this.qnaAnswerDate = qnaAnswerDate;
		this.qnaAnswerCheck = qnaAnswerCheck;
	}

	public Qna(String qnaTitle, String qnaContent, String qnaWriter) {
		super();
		this.qnaTitle = qnaTitle;
		this.qnaContent = qnaContent;
		this.qnaWriter = qnaWriter;
		
	}

	public Qna(String answerTitle, String answerContent, String qnaAnswerDate, String qnaAnswerCheck) {
		super();
		this.answerTitle = answerTitle;
		this.answerContent = answerContent;
		this.qnaAnswerDate = qnaAnswerDate;
		this.qnaAnswerCheck = qnaAnswerCheck;
	}

	public int getQnaPk() {
		return qnaPk;
	}

	public void setQnaPk(int qnaPk) {
		this.qnaPk = qnaPk;
	}

	public String getQnaTitle() {
		return qnaTitle;
	}

	public void setQnaTitle(String qnaTitle) {
		this.qnaTitle = qnaTitle;
	}

	public String getAnswerTitle() {
		return answerTitle;
	}

	public void setAnswerTitle(String answerTitle) {
		this.answerTitle = answerTitle;
	}

	public String getAnswerContent() {
		return answerContent;
	}

	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}

	public String getQnaContent() {
		return qnaContent;
	}

	public void setQnaContent(String qnaContent) {
		this.qnaContent = qnaContent;
	}

	public String getQnaWriter() {
		return qnaWriter;
	}

	public void setQnaWriter(String qnaWriter) {
		this.qnaWriter = qnaWriter;
	}

	public String getQnaDate() {
		return qnaDate;
	}

	public void setQnaDate(String qnaDate) {
		this.qnaDate = qnaDate;
	}

	public String getQnaAnswerDate() {
		return qnaAnswerDate;
	}

	public void setQnaAnswerDate(String qnaAnswerDate) {
		this.qnaAnswerDate = qnaAnswerDate;
	}

	public String getQnaAnswerCheck() {
		return qnaAnswerCheck;
	}

	public void setQnaAnswerCheck(String qnaAnswerCheck) {
		this.qnaAnswerCheck = qnaAnswerCheck;
	}
	
	
	
	
}
