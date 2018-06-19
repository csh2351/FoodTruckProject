package customerStoreSignup.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Signup implements Serializable{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = -7642965013559545524L;
	
	private int truckPk;
	   private String truckName;
	   private String truckOriginalImage;
	   private String truckRenameImage;
	   private String truckLocation; //푸드트럭주소
	   private String truckInfoName; //상호명
	   private int truckInfoRegisterNumber; //사업자번호
	   private String truckContent;
	   private String truckStatus;
	   private Date truckOpenTime;
	   private Date truckCloseTime;
	   private String truckApprove;
	   private String truckCategory;
	   private int truckStar;
	   private int memberPk;
	   private int latitude;   
	   private int logitude;
	   private String truckHoliday;
	   private int truckPrice;
	   private String memberId;
	   
	   public Signup() {}
	   
	   
	   public Signup(int truckInfoRegisterNumber,  String truckInfoName, String truckLocation, int memberPk) {
		   
		   this.truckInfoRegisterNumber = truckInfoRegisterNumber;
		   this.truckInfoName = truckInfoName;
		   this.truckLocation = truckLocation;
		   this.memberPk = memberPk;
	   };

	public Signup(int truckPk, String truckName, String truckOriginalImage, String truckRenameImage,
			String truckLocation, String truckInfoName, int truckInfoRegisterNumber, String truckContent,
			String truckStatus, Date truckOpenTime, Date truckCloseTime, String truckApprove, String truckCategory,
			int truckStar, int memberPk, int latitude, int logitude, String truckHoliday, int truckPrice,String memberId) {
		super();
		this.truckPk = truckPk;
		this.truckName = truckName;
		this.truckOriginalImage = truckOriginalImage;
		this.truckRenameImage = truckRenameImage;
		this.truckLocation = truckLocation;
		this.truckInfoName = truckInfoName;
		this.truckInfoRegisterNumber = truckInfoRegisterNumber;
		this.truckContent = truckContent;
		this.truckStatus = truckStatus;
		this.truckOpenTime = truckOpenTime;
		this.truckCloseTime = truckCloseTime;
		this.truckApprove = truckApprove;
		this.truckCategory = truckCategory;
		this.truckStar = truckStar;
		this.memberPk = memberPk;
		this.latitude = latitude;
		this.logitude = logitude;
		this.truckHoliday = truckHoliday;
		this.truckPrice = truckPrice;
		this.memberId = memberId;
	}

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

	public String getTruckLocation() {
		return truckLocation;
	}

	public void setTruckLocation(String truckLocation) {
		this.truckLocation = truckLocation;
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
		this.truckStatus = truckStatus;
	}

	public Date getTruckOpenTime() {
		return truckOpenTime;
	}

	public void setTruckOpenTime(Date truckOpenTime) {
		this.truckOpenTime = truckOpenTime;
	}

	public Date getTruckCloseTime() {
		return truckCloseTime;
	}

	public void setTruckCloseTime(Date truckCloseTime) {
		this.truckCloseTime = truckCloseTime;
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

	public int getLatitude() {
		return latitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public int getLogitude() {
		return logitude;
	}

	public void setLogitude(int logitude) {
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
	
	
	
	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Signup [truckPk=" + truckPk + ", truckName=" + truckName + ", truckOriginalImage=" + truckOriginalImage
				+ ", truckRenameImage=" + truckRenameImage + ", truckLocation=" + truckLocation + ", truckInfoName="
				+ truckInfoName + ", truckInfoRegisterNumber=" + truckInfoRegisterNumber + ", truckContent="
				+ truckContent + ", truckStatus=" + truckStatus + ", truckOpenTime=" + truckOpenTime
				+ ", truckCloseTime=" + truckCloseTime + ", truckApprove=" + truckApprove + ", truckCategory="
				+ truckCategory + ", truckStar=" + truckStar + ", memberPk=" + memberPk + ", latitude=" + latitude
				+ ", logitude=" + logitude + ", truckHoliday=" + truckHoliday + ", truckPrice=" + truckPrice + "]";
	};
	   
	   
	   
	   

}
