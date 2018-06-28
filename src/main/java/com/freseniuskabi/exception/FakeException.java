package com.freseniuskabi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class FakeException extends RuntimeException {

	public FakeException(String message) {
		super("FakeException: " + message);
	}

}
