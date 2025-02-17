package com.rpi.alexandria.controller;

import com.rpi.alexandria.controller.response.AppResponse;
import com.rpi.alexandria.exception.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.OffsetDateTime;

@ControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(value = { UserException.class })
	public ResponseEntity<AppResponse> usernameAlreadyExistsException(UserException ex, WebRequest request) {
		AppResponse appResponse = AppResponse.builder().dateTime(OffsetDateTime.now())
				.httpStatus(HttpStatus.BAD_REQUEST).message(ex.getMessage()).build();
		return new ResponseEntity<>(appResponse, appResponse.getHttpStatus());
	}

}
