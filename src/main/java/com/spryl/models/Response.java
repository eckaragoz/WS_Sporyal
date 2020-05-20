package com.spryl.models;

public class Response {	

	private int responseCode;
	private String responseMesssage;
	
	public Response(int responseCode, String responseMesssage) {
		super();
		this.responseCode = responseCode;
		this.responseMesssage = responseMesssage;
	}
	
	public Response() {}
	
	
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMesssage() {
		return responseMesssage;
	}
	public void setResponseMesssage(String responseMesssage) {
		this.responseMesssage = responseMesssage;
	}
	
	
	

}
