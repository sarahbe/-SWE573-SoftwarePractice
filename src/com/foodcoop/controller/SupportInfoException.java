package com.foodcoop.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;


public class SupportInfoException extends RuntimeException {

	/**
	 * Unique ID for Serialized object
	 */
	private static final long serialVersionUID = 4657491283614755649L;

// @ExceptionHandler(SupportInfoException.class)
//	    @ResponseStatus(HttpStatus.NOT_FOUND)
// @RequestMapping("/404")
//	    public String handleResourceNotFoundException() {
//	        return "404";
//	    }
//	
//	public SupportInfoException(String msg) {
//		super(msg);
//	}
//
//	public SupportInfoException(String msg, Throwable t) {
//		super(msg, t);
//	}

}
