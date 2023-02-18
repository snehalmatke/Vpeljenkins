package springbootawsexample.userException;

public class UserException extends RuntimeException{

	private static final long serialVersionUID = 215232344516490651L;

	public UserException(String message) {
		super(message);
	}
}
