package com.te.mailsimulation.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.te.mailsimulation.beans.EmailResponse;
import com.te.mailsimulation.exceptions.EmailException;

@RestControllerAdvice
public class EmailControllerAdvice {

	@ExceptionHandler(EmailException.class)
	public EmailResponse handleEmailException(EmailException exception) {
		EmailResponse response = new EmailResponse();
		response.setStatusCode(500);
		response.setMsg("Failure");
		response.setDescription(exception.getMessage());
		return response;
	}
}
