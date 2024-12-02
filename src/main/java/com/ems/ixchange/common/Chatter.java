package com.ems.ixchange.common;


/**
* This class represents a chatter in the chat room.
* For each Chatter object a memberId, name, sex and login time is required.
*/
public class Chatter
{
	private String memberId = null;
	private String name = null;
	private String sex = null;
	private long loginTime = -1;
	private long enteredInRoomAt = -1;
	
	public Chatter() {
		super();
	}
	
	public Chatter(String memberId, String name, String sex, long loginTime) {
		super();
		this.memberId = memberId;
		this.name = name;
		this.sex = sex;
		this.loginTime = loginTime;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public long getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(long loginTime) {
		this.loginTime = loginTime;
	}

	public long getEnteredInRoomAt() {
		return enteredInRoomAt;
	}

	public void setEnteredInRoomAt(long enteredInRoomAt) {
		this.enteredInRoomAt = enteredInRoomAt;
	}
}