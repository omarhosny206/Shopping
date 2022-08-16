package com.bm.exception;

public enum Errors {
	UserNotFound("Incorrect email or password"),
	EmailNotUnique("Email already taken, please choose another one");
	
	private final String errorMessage;

	private Errors(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	
}