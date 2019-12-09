package CustomeExceptionExample;

public class DailyLimitException extends RuntimeException{
	String msg;
	

	public DailyLimitException() {
		super();
	}
	public DailyLimitException(String msg) {
		super();
		this.msg = msg;
	}
	@Override
	public String getMessage() {
		return msg;
	}

}
