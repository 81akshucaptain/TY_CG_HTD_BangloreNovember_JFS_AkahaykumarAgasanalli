package CustomeExceptionExample;

public class TestAtm {
	public static void main(String[] args) {
		System.out.println("main started");
		StateBankAtm a1=new StateBankAtm();
		try {
			a1.withdraw(41000);	
		}catch(DailyLimitException e) {
			System.out.println(e.getMessage());
		}
		System.out.println("main ended");
	
	}
}
