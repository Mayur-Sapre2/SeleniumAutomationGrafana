package com.selenium.exceptions;

public class InavalidPathForFilesException extends FrameworkException{
	
	public InavalidPathForFilesException(String message) {
		super(message);
	}
	
	public InavalidPathForFilesException(String message,Throwable cause) {
		super(message,cause);
	}
}
