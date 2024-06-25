package com.drug.exception;

public class DrugNotFoundException extends Exception{
	public DrugNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DrugNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public DrugNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DrugNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public DrugNotFoundException(String msg) {
		super(msg);
	}

}
