package com.taotao.util.exception;

public class MyException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3512270909684800953L;
	protected String  message;
	public MyException() {
		
	}
	public MyException(String message){
		super(message);
		this.message=message;
		
	}
	
}
