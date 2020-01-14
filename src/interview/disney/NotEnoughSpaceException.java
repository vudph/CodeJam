package interview.disney;

public class NotEnoughSpaceException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2587690710797800967L;

	public NotEnoughSpaceException(String message) {
		super(message);
	}
}
