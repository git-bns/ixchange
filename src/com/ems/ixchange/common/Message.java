package com.ems.ixchange.common;

/**
* Represents a Message sent by a user.
*/
public class Message
{
	private String chatterId = null;
	private String message = null;
	private long timeStamp;

	public Message(String chatterId, String message, long timeStamp)
	{
		this.setChatterId(chatterId);
		this.message= message;
		this.timeStamp = timeStamp;
	}

	public String getChatterId() {
		return chatterId;
	}

	public void setChatterId(String chatterId) {
		this.chatterId = chatterId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
}