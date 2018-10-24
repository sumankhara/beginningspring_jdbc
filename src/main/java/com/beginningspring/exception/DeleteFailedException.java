package com.beginningspring.exception;

import org.springframework.dao.DataAccessException;

@SuppressWarnings("serial")
public class DeleteFailedException extends DataAccessException {

	public DeleteFailedException(String msg) {
		super(msg);
	}

}
