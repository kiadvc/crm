package ch.zli3.ksh18a.andkli.crm.exceptions;

@SuppressWarnings("serial")
public class NoStackTraceException extends RuntimeException{
	public NoStackTraceException() {
		super("", null, true, false);
	}

}
