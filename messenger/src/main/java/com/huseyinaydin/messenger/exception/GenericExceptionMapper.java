package com.huseyinaydin.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

import com.huseyinaydin.messenger.model.ErrorMessage;

public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable arg0) {
		ErrorMessage errorMessage = new ErrorMessage(arg0.getMessage(), 500, "Aranan bulunamadı");
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				.entity(errorMessage)
				.build();
	}
}