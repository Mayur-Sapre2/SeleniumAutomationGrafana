/**
 * 
 */
package com.selenium.exceptions;

/**
 * Jun 16, 2021
 * @author Mayur Sapre
 * @version 1.0
 * @since 1.0
 */
@SuppressWarnings("serial")
public class BrowserInvocationFailedException extends FrameworkException {
	
	public BrowserInvocationFailedException(String message) {
		super(message);
	}
	
	public BrowserInvocationFailedException(String message,Throwable cause) {
		super(message,cause);
	}

}
