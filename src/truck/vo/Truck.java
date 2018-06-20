package truck.vo;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class Truck implements Serializable {

	public Truck() {
		super();
	}

	private static final long serialVersionUID = 1967483248967652055L;
	private int truckPk;
	private String truckName;
	private String truckOriginalImage;
	private String truckRenameImage;
	private String trucklocation;
	private String truckInfoName;
	private int truckInfoRegisterNumber;
	private String truckContent;
	private String truckStatus;
	private Timestamp truckOpenTime;
	private Timestamp truckCloseTime;
	private String truckApprove;
	private String truckCategory;
	private int truckStar;
	private int memberPk;
	private double latitude;
	private double logitude;
	private String truckHoliday;
	private int truckPrice;
	private int reviewCount;

	public int getTruckPk() {
		return truckPk;
	}

	public void setTruckPk(int truckPk) {
		this.truckPk = truckPk;
	}

	public String getTruckName() {
		return truckName;
	}

	public void setTruckName(String truckName) {
		this.truckName = truckName;
	}

	public String getTruckOriginalImage() {
		return truckOriginalImage;
	}

	public void setTruckOriginalImage(String truckOriginalImage) {
		this.truckOriginalImage = truckOriginalImage;
	}

	public String getTruckRenameImage() {
		return truckRenameImage;
	}

	public void setTruckRenameImage(String truckRenameImage) {
		this.truckRenameImage = truckRenameImage;
	}

	public String getTrucklocation() {
		return trucklocation;
	}

	public void setTrucklocation(String trucklocation) {
		this.trucklocation = trucklocation;
	}

	public String getTruckInfoName() {
		return truckInfoName;
	}

	public void setTruckInfoName(String truckInfoName) {
		this.truckInfoName = truckInfoName;
	}

	public int getTruckInfoRegisterNumber() {
		return truckInfoRegisterNumber;
	}

	public void setTruckInfoRegisterNumber(int truckInfoRegisterNumber) {
		this.truckInfoRegisterNumber = truckInfoRegisterNumber;
	}

	public String getTruckContent() {
		return truckContent;
	}

	public void setTruckContent(String truckContent) {
		this.truckContent = truckContent;
	}

	public String getTruckStatus() {
		return truckStatus;
	}

	public void setTruckStatus(String truckStatus) {
		if (truckStatus == null) {
			this.truckStatus = "f";
		}
		this.truckStatus = truckStatus;
	}

	public Timestamp getTruckOpenTime() {
		return truckOpenTime;
	}

	public void setTruckOpenTime(Timestamp time1) {
		this.truckOpenTime = time1;
	}

	public Timestamp getTruckCloseTime() {
		return truckCloseTime;
	}

	public void setTruckCloseTime(Timestamp sqldate2) {
		this.truckCloseTime = sqldate2;
	}

	public String getTruckApprove() {
		return truckApprove;
	}

	public void setTruckApprove(String truckApprove) {
		this.truckApprove = truckApprove;
	}

	public String getTruckCategory() {
		return truckCategory;
	}

	public void setTruckCategory(String truckCategory) {
		this.truckCategory = truckCategory;
	}

	public int getTruckStar() {
		return truckStar;
	}

	public void setTruckStar(int truckStar) {
		this.truckStar = truckStar;
	}

	public int getMemberPk() {
		return memberPk;
	}

	public void setMemberPk(int memberPk) {
		this.memberPk = memberPk;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLogitude() {
		return logitude;
	}

	public void setLogitude(double logitude) {
		this.logitude = logitude;
	}

	public String getTruckHoliday() {
		return truckHoliday;
	}

	public void setTruckHoliday(String truckHoliday) {
		this.truckHoliday = truckHoliday;
	}

	public int getTruckPrice() {
		return truckPrice;
	}

	public void setTruckPrice(int truckPrice) {
		this.truckPrice = truckPrice;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Truck [truckPk=" + truckPk + ", truckName=" + truckName + ", truckOriginalImage=" + truckOriginalImage
				+ ", truckRenameImage=" + truckRenameImage + ", trucklocation=" + trucklocation + ", truckInfoName="
				+ truckInfoName + ", truckInfoRegisterNumber=" + truckInfoRegisterNumber + ", truckContent="
				+ truckContent + ", truckStatus=" + truckStatus + ", truckOpenTime=" + truckOpenTime
				+ ", truckCloseTime=" + truckCloseTime + ", truckApprove=" + truckApprove + ", truckCategory="
				+ truckCategory + ", truckStar=" + truckStar + ", memberPk=" + memberPk + ", latitude=" + latitude
				+ ", logitude=" + logitude + ", truckHoliday=" + truckHoliday + ", truckPrice=" + truckPrice + "]";
	}

	// 리뷰카운트..
	public int getReviewCount() {
		return reviewCount;
	}

	public void setReviewCount(int reviewCount) {
		this.reviewCount = reviewCount;
	}

}