package truck.vo;

import java.sql.Date;

public class TruckReview {

	public TruckReview(){
		
	}
	
	
	private int reviewPk;
	private String reviewTitle;
	private String reviewContent;
	private String reviewName;
	private Date reviewDate;
	private String reviewComment;
	public int getReviewPk() {
		return reviewPk;
	}
	public void setReviewPk(int reviewPk) {
		this.reviewPk = reviewPk;
	}
	public String getReviewTitle() {
		return reviewTitle;
	}
	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}
	public String getReviewContent() {
		return reviewContent;
	}
	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}
	public String getReviewName() {
		return reviewName;
	}
	public void setReviewName(String reviewName) {
		this.reviewName = reviewName;
	}
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	public String getReviewComment() {
		return reviewComment;
	}
	public void setReviewComment(String reviewComment) {
		this.reviewComment = reviewComment;
	}
	public String getReviewOimg() {
		return reviewOimg;
	}
	public void setReviewOimg(String reviewOimg) {
		this.reviewOimg = reviewOimg;
	}
	public String getReviewRimg() {
		return reviewRimg;
	}
	public void setReviewRimg(String reviewRimg) {
		this.reviewRimg = reviewRimg;
	}
	public int getReviewStar() {
		return reviewStar;
	}
	public void setReviewStar(int reviewStar) {
		this.reviewStar = reviewStar;
	}
	public int getMemberPk() {
		return memberPk;
	}
	public void setMemberPk(int memberPk) {
		this.memberPk = memberPk;
	}
	public int getTruckPk() {
		return truckPk;
	}
	public void setTruckPk(int truckPk) {
		this.truckPk = truckPk;
	}
	private String reviewOimg;
	private String reviewRimg;
	private int reviewStar;
	private int memberPk;
	private int truckPk;
	
	
}
