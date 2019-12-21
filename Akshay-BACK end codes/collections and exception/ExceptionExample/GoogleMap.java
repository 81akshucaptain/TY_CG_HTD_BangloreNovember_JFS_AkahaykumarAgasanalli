package ExceptionExample;

public class GoogleMap {
	void findLocation(String loc) {
		try{
			System.out.println(loc.length());
		}catch(NullPointerException e) {
			System.out.println("the error is thowing to called function");
			throw e;
		}
	}

}
