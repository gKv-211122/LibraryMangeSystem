package com.lms.library;

public class InvalidChoiceException extends RuntimeException {

	@Override
	public String toString() {
		
		return "Please Enter Number between 1 - 7 or y -- For continue, n -- For Exit From the Book Store";
	}
	
}
