package com.overread.exceptions;

public class PasswordLengthException extends Exception
{
	private static final long serialVersionUID = 1L;
	
	public PasswordLengthException(String message)
	{
		super(message);
	}

	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}
	
}
