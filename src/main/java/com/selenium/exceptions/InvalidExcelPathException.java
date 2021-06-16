package com.selenium.exceptions;

import java.nio.file.InvalidPathException;

public class InvalidExcelPathException extends InavalidPathForFilesException {

	public InvalidExcelPathException(String message) {
		super(message);
	}
	
	public InvalidExcelPathException(String message,Throwable cause) {
		super(message,cause);
	}
}
