package edu.handong.analysis;

public class CustomizedException extends Exception {
	
	public CustomizedException() {
		super ("There is Exception! Data is in difficulty in handling.");
	}
	
	public CustomizedException(String message) {
		super(message);
	}
}
