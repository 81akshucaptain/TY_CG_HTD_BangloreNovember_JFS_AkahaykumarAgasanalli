package loosecoupling;

public class TestAtm {
public static void main(String[] args) {
	Withdraw w=new Withdraw();
	System.out.println("im in");

	  //Atm a=new Atm();
	//w.moneyDrawn(a);
	
	StateBank s=new StateBank();
	//w.moneyDrawn(s);
	
	HdfcBank h=new HdfcBank();
	//w.moneyDrawn(h);
    
	Atm a1=new HdfcBank();
	w.moneyDrawn(a1);


}
}
