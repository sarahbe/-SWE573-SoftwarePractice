package com.foodcoop.controller;

import java.sql.SQLException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandlingController {
	  public static final String DEFAULT_ERROR_VIEW = "error";
	
	@ExceptionHandler({ SQLException.class, DataAccessException.class })
	public String databaseError(Exception exception) {
		// Nothing to do. Return value 'databaseError' used as logical view name
		// of an error page, passed to view-resolver(s) in usual way.
		// logger.error("Request raised " + exception.getClass().getSimpleName());
		ModelAndView model = new ModelAndView();
		model.addObject("exception", exception);
	return "exception";
	}

//	  @ExceptionHandler(value = Exception.class)
//	    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
//	        // If the exception is annotated with @ResponseStatus rethrow it and let
//	        // the framework handle it - like the OrderNotFoundException example
//	        // at the start of this post.
//	        // AnnotationUtils is a Spring Framework utility class.
//	        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null)
//	            throw e;
//
//	        // Otherwise setup and send the user to a default error-view.
//	        ModelAndView mav = new ModelAndView();
//	        mav.addObject("exception", e);
//	        mav.addObject("url", req.getRequestURL());
//	        mav.setViewName(DEFAULT_ERROR_VIEW);
//	        return mav;
//	    }
//	  
//	@ExceptionHandler(SupportInfoException.class)
//	public ModelAndView handleError(HttpServletRequest req, Exception exception)
//			throws Exception {
//
//		// Rethrow annotated exceptions or they will be processed here instead.
//		if (AnnotationUtils.findAnnotation(exception.getClass(),
//				ResponseStatus.class) != null)
//			throw exception;
//
////		logger.error("Request: " + req.getRequestURI() + " raised " + exception);
//
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("exception", exception);
//		mav.addObject("url", req.getRequestURL());
//		mav.addObject("timestamp", new Date().toString());
//		mav.addObject("status", 500);
//
//		mav.setViewName("exception");
//		return mav;
//	}

}
