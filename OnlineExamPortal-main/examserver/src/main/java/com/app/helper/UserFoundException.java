package com.app.helper;

public class UserFoundException extends Exception{
	
	public UserFoundException() {
		super("User with username  is alredy present in database");
	}
	public UserFoundException(String msg)
	{
		super(msg);
	}
}
