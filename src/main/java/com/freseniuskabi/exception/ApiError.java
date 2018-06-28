package com.freseniuskabi.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

public class ApiError {
	private HttpStatus status;
	private Date timestamp;
	private String message;
	private String details;

	public ApiError(HttpStatus status, String message, String details) {
		super();
		this.status = status;
		this.timestamp = new Date();
		this.message = message;
		this.details = details;
	}

	public HttpStatus getStatus() {
		return this.status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public Date getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return this.details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}