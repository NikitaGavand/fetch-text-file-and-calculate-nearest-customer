package com.intercom.home.assignment.exception;

@SuppressWarnings("serial")
public class CustomerException extends Exception {
	String message;

	public CustomerException(String msg) {

		{
			message = msg;
		}
	}

	@Override
	public String getMessage() {
		return message;
	}
}
