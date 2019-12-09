package CustomeExceptionExample;

public class StateBankAtm {
void withdraw(int a) {
	if(a>40000) {
		//IT WILL CREAT THE NEW OBJECT OF CUSTOMEEXCEPTION HENCE WITH STRIGN ARGUMENT A CONSTRUCTOR
		// WILL BE CALLED IN THE DAILYLIMITEXCEPTION
		throw new DailyLimitException("hell lot money to withdraw");
	}
}
}
