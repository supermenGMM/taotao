package com.taotao.util.exception;

public class FileException extends MyException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6016300477864125125L;
	
	public FileException() {
	}

	public FileException(String message) {
		super(message);
		this.message=message;
	}
}
