package truck.vo;

import java.io.Serializable;
import java.sql.Date;

public class Truck implements Serializable{
	
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
private Date truckOpenTime;
private Date truckCloseTime;
private String truckApprove;
private String truckGeolacation;
private String truckHoiliday;
@Override
public String toString() {
	return "Truck [truckPk=" + truckPk + ", truckName=" + truckName + ", truckOriginalImage=" + truckOriginalImage
			+ ", truckRenameImage=" + truckRenameImage + ", trucklocation=" + trucklocation + ", truckInfoName="
			+ truckInfoName + ", truckInfoRegisterNumber=" + truckInfoRegisterNumber + ", truckContent=" + truckContent
			+ ", truckStatus=" + truckStatus + ", truckOpenTime=" + truckOpenTime + ", truckCloseTime=" + truckCloseTime
			+ ", truckApprove=" + truckApprove + ", truckGeolacation=" + truckGeolacation + ", truckHoiliday="
			+ truckHoiliday + ", truckCategory=" + truckCategory + ", truckStar=" + truckStar + ", memberPk=" + memberPk
			+ "]";
}
public Truck(int truckPk, String truckName, String truckOriginalImage, String truckRenameImage, String trucklocation,
		String truckInfoName, int truckInfoRegisterNumber, String truckContent, String truckStatus, Date truckOpenTime,
		Date truckCloseTime, String truckApprove, String truckGeolacation, String truckHoiliday, String truckCategory,
		int truckStar, int memberPk) {
	super();
	this.truckPk = truckPk;
	this.truckName = truckName;
	this.truckOriginalImage = truckOriginalImage;
	this.truckRenameImage = truckRenameImage;
	this.trucklocation = trucklocation;
	this.truckInfoName = truckInfoName;
	this.truckInfoRegisterNumber = truckInfoRegisterNumber;
	this.truckContent = truckContent;
	this.truckStatus = truckStatus;
	this.truckOpenTime = truckOpenTime;
	this.truckCloseTime = truckCloseTime;
	this.truckApprove = truckApprove;
	this.truckGeolacation = truckGeolacation;
	this.truckHoiliday = truckHoiliday;
	this.truckCategory = truckCategory;
	this.truckStar = truckStar;
	this.memberPk = memberPk;
}
private String truckCategory;
private int	truckStar;
private int memberPk;
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
public String getTruckGeolacation() {
	return truckGeolacation;
}
public void setTruckGeolacation(String truckGeolacation) {
	this.truckGeolacation = truckGeolacation;
}
public String getTruckHoiliday() {
	return truckHoiliday;
}
public void setTruckHoiliday(String truckHoiliday) {
	this.truckHoiliday = truckHoiliday;
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
public static long getSerialversionuid() {
	return serialVersionUID;
}

}
