package com.selenium.exceptions;

public class InvalidPathForPropertyFileException extends InavalidPathForFilesException {

	public InvalidPathForPropertyFileException(String message) {
		super(message);
	}
	
	public InvalidPathForPropertyFileException(String message,Throwable cause) {
		super(message,cause);
	}
}
