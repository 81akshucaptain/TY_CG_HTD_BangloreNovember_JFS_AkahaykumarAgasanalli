package interfacepgms;

public class Bosch implements Toyota {
	public static void main(String[] args) {
		
	Bosch b=new Bosch();
	b.design();
	b.engine();
	Toyota t=new Bosch();
	t.design();
	t.engine();
	}
//implementation for the Toyota interfaces
public void design(){
	System.out.println("in design method");
}
public void engine()
{
	System.out.println("in engine method");
}
}

