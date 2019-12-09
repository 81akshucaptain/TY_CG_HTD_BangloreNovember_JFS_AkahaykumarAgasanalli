package variables;

public class ChipsMain {
	public static void main(String[] args) {
		TestChips t=new TestChips();
		
		Chips c=new Chips();
		t.allChips(c);
		
		Lays l=new Lays();
		t.allChips(l);
		
		Bingo b=new Bingo();
		t.allChips(b);
		
	}

}
