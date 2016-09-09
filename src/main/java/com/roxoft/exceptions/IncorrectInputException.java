package com.roxoft.exceptions;

public class IncorrectInputException extends Exception {

String message = "Incorrect input";
	
	public IncorrectInputException(String message) {
        super(message);
	}
	
}
