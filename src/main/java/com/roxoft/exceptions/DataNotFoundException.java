package com.roxoft.exceptions;

public class DataNotFoundException  extends Exception {
String message = "Data not found in mySQL";
	
	public DataNotFoundException(String message) {
        super(message);
	}
}
