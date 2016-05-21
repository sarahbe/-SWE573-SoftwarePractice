package com.foodcoop.controller;

import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.foodcoop.domain.CustomGenericException;

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
	
	@ExceptionHandler(CustomGenericException.class)
	public ModelAndView handleCustomException(CustomGenericException ex) {

		ModelAndView model = new ModelAndView("exception");
		model.addObject("errCode", ex.getErrCode());
		model.addObject("errMsg", ex.getErrMsg());

		return model;

	}
}
