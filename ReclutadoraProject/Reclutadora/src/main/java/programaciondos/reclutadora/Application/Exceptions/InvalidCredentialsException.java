package programaciondos.reclutadora.Application.Exceptions;

public class InvalidCredentialsException extends RuntimeException {
	
	public InvalidCredentialsException(String message, Throwable ex){
		super(message, ex);
	}
	
	public InvalidCredentialsException(String message){
		super(message);
	}
	
}
