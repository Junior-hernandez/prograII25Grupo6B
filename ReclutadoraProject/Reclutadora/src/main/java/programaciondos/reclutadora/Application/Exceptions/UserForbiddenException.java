package programaciondos.reclutadora.Application.Exceptions;

public class UserForbiddenException extends RuntimeException{
	
	public UserForbiddenException(String message, Throwable cause){
		super(message, cause);
	}
	
	public UserForbiddenException(String message){
		super(message);
	}
}
