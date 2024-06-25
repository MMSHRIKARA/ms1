package com.supplier.exception;

public class SupplierInvalidException extends Exception{
	public SupplierInvalidException(String msg) {
		super(msg);
	}

	public SupplierInvalidException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SupplierInvalidException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public SupplierInvalidException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public SupplierInvalidException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
