package com.anytimedeveloper.exception;

import java.time.LocalDateTime;

public class ErrorDetails {
	
	private LocalDateTime timestamp;
	private String messgae;
	private String detials;
	
	public ErrorDetails(LocalDateTime timestamp, String messgae, String detials) {
		super();
		this.timestamp = timestamp;
		this.messgae = messgae;
		this.detials = detials;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public String getMessgae() {
		return messgae;
	}

	public String getDetials() {
		return detials;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public void setMessgae(String messgae) {
		this.messgae = messgae;
	}

	public void setDetials(String detials) {
		this.detials = detials;
	}
	
	
	
	

}
