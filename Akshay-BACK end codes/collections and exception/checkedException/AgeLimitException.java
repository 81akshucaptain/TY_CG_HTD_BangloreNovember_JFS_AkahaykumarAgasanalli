package checkedException;

public class AgeLimitException extends Exception{
	String msg="age should be more than 18";
	AgeLimitException(){

	}
	AgeLimitException(String msg){
		this.msg=msg;
	}	
	public String getMessage() {
		return this.msg;
	}
}
