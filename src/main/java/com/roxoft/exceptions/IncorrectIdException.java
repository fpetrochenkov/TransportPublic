package com.roxoft.exceptions;

public class IncorrectIdException extends Exception{
	
	String message = "Id doesn't excist!";
	
	public IncorrectIdException(String message) {
        super(message);
	}
}
