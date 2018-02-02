package com.sundata.common.exception;

public class ServiceException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ServiceException(String err){
		super(err);
	}

	public ServiceException(String string, Exception e) {
		super(string, e);
	}
	
	public ServiceException(Throwable ex) {
		super(ex);
	}
	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(){}
}
