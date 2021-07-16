package ch.zli3.ksh18a.andkli.crm.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Boat already exists")
public class BoatAlreadyExistsException extends RuntimeException{
	public BoatAlreadyExistsException() {
		super("", null, true, false);
	}

}
