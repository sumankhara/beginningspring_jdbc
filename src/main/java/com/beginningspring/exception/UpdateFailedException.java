package com.beginningspring.exception;

import org.springframework.dao.DataAccessException;

@SuppressWarnings("serial")
public class UpdateFailedException extends DataAccessException {

	public UpdateFailedException(String msg) {
		super(msg);
	}

}
