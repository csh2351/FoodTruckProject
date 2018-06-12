package truck.vo;

import java.io.Serializable;
import java.sql.Date;

public class TruckReviewComment implements Serializable{
	
	private static final long serialVersionUID = -3515805185897818980L;
	
	private int reviewCommentPk;
	private int reviewCommentLevel;
	private String reviewCommnetWriter;
	private String reviewCommnetContent;
	private int reviewRef;
	private int reviewCommentRef;
	private Date reivewCommentDate;
	private String reviewCommentOimage;
	private String reviewCommentRimage;
	private int memberPk;
	private int truckPk;
	private double reviewStar;
	
	public TruckReviewComment() {
	}
	
	public TruckReviewComment(int reviewCommentPk, int reviewCommentLevel, String reviewCommnetWriter,
			String reviewCommnetContent, int reviewRef, int reviewCommentRef, Date reivewCommentDate,
			String reviewCommentOimage, String reviewCommentRimage, int memberPk, int truckPk, int reviewStar) {
		super();
		this.reviewCommentPk = reviewCommentPk;
		this.reviewCommentLevel = reviewCommentLevel;
		this.reviewCommnetWriter = reviewCommnetWriter;
		this.reviewCommnetContent = reviewCommnetContent;
		this.reviewRef = reviewRef;
		this.reviewCommentRef = reviewCommentRef;
		this.reivewCommentDate = reivewCommentDate;
		this.reviewCommentOimage = reviewCommentOimage;
		this.reviewCommentRimage = reviewCommentRimage;
		this.memberPk = memberPk;
		this.truckPk = truckPk;
		this.setReviewStar(reviewStar);
	}
	public int getReviewCommentPk() {
		return reviewCommentPk;
	}
	public void setReviewCommentPk(int reviewCommentPk) {
		this.reviewCommentPk = reviewCommentPk;
	}
	public int getReviewCommentLevel() {
		return reviewCommentLevel;
	}
	public void setReviewCommentLevel(int reviewCommentLevel) {
		this.reviewCommentLevel = reviewCommentLevel;
	}
	public String getReviewCommnetWriter() {
		return reviewCommnetWriter;
	}
	public void setReviewCommnetWriter(String reviewCommnetWriter) {
		this.reviewCommnetWriter = reviewCommnetWriter;
	}
	public String getReviewCommnetContent() {
		return reviewCommnetContent;
	}
	public void setReviewCommnetContent(String reviewCommnetContent) {
		this.reviewCommnetContent = reviewCommnetContent;
	}
	public int getReviewRef() {
		return reviewRef;
	}
	public void setReviewRef(int reviewRef) {
		this.reviewRef = reviewRef;
	}
	public int getReviewCommentRef() {
		return reviewCommentRef;
	}
	public void setReviewCommentRef(int reviewCommentRef) {
		this.reviewCommentRef = reviewCommentRef;
	}
	public Date getReivewCommentDate() {
		return reivewCommentDate;
	}
	public void setReivewCommentDate(Date reivewCommentDate) {
		this.reivewCommentDate = reivewCommentDate;
	}
	public String getReviewCommentOimage() {
		return reviewCommentOimage;
	}
	public void setReviewCommentOimage(String reviewCommentOimage) {
		this.reviewCommentOimage = reviewCommentOimage;
	}
	public String getReviewCommentRimage() {
		return reviewCommentRimage;
	}
	public void setReviewCommentRimage(String reviewCommentRimage) {
		this.reviewCommentRimage = reviewCommentRimage;
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
	public double getReviewStar() {
		return reviewStar;
	}
	
	public void setReviewStar(double reviewStar) {
		this.reviewStar = reviewStar;
	}

	@Override
	public String toString() {
		return "TruckReviewComment [reviewCommentPk=" + reviewCommentPk + ", reviewCommentLevel=" + reviewCommentLevel
				+ ", reviewCommnetWriter=" + reviewCommnetWriter + ", reviewCommnetContent=" + reviewCommnetContent
				+ ", reviewRef=" + reviewRef + ", reviewCommentRef=" + reviewCommentRef + ", reivewCommentDate="
				+ reivewCommentDate + ", reviewCommentOimage=" + reviewCommentOimage + ", reviewCommentRimage="
				+ reviewCommentRimage + ", memberPk=" + memberPk + ", truckPk=" + truckPk + ", reviewStar=" + reviewStar
				+ "]";
	}
	
	
	


}
