package io.github.julianjupiter.app.util;

import java.time.ZonedDateTime;

public class Error {
	private String message;
	private ZonedDateTime createdAt;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ZonedDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(ZonedDateTime createdAt) {
		this.createdAt = createdAt;
	}
}
