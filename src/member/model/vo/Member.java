
package member.model.vo;

import java.io.Serializable;

public class Member implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 409583592833642852L;
	
	private int memberPk;
	private String memberId;
	private String memberPw;
	private String memberName;
	private String memberPhone;
	private String memberEmail;
	private String memberLevel;
	private String memberAddress;
	
	
	public Member() {}
	
	public Member(String memberId, String memberPw, String memberName, String memberPhone,
			String memberEmail, String memberAddress) {
		super();
		
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
		this.memberAddress = memberAddress;
	}


	public Member(int memberPk, String memberId, String memberPw, String memberName, String memberPhone,
			String memberEmail, String memberLevel, String memberAddress) {
		super();
		this.memberPk = memberPk;
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberName = memberName;
		this.memberPhone = memberPhone;
		this.memberEmail = memberEmail;
		this.memberLevel = memberLevel;
		this.memberAddress = memberAddress;
	}


	public int getMemberPk() {
		return memberPk;
	}


	public void setMemberPk(int memberPk) {
		this.memberPk = memberPk;
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public String getMemberPw() {
		return memberPw;
	}


	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}


	public String getMemberName() {
		return memberName;
	}


	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}


	public String getMemberPhone() {
		return memberPhone;
	}


	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}


	public String getMemberEmail() {
		return memberEmail;
	}


	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}


	public String getMemberLevel() {
		return memberLevel;
	}


	public void setMemberLevel(String memberLevel) {
		this.memberLevel = memberLevel;
	}


	public String getMemberAddress() {
		return memberAddress;
	}


	public void setMemberAddress(String memberAddress) {
		this.memberAddress = memberAddress;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Member [memberPk=" + memberPk + ", memberId=" + memberId + ", memberPw=" + memberPw + ", memberName="
				+ memberName + ", memberPhone=" + memberPhone + ", memberEmail=" + memberEmail + ", memberLevel="
				+ memberLevel + ", memberAddress=" + memberAddress + "]";
	}

	
	
	

}
