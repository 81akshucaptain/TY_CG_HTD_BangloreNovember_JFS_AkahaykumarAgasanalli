package checkedException;

public class ToFindPerson {
	public static void main(String[] args) {
		System.out.println("main sarted");
		Person p1=new Person();

		/*try {
			//To deal with CLONE NOT SUPPORTED,DUE TO CLONABLE INTERFACE HAS TO IMPLEMENT,else exception
			//SO we must override the existing clone method to Perdon class
			//by implementing the CLONAEABLE interface
			
			Object p2=p1.clone();
			System.out.println("clone is been executed");

			//To check CLASS EXISSTENCE /verify the checked execption COMPLIE TIME CHECKING
			Class c1=Class.forName("checkedException.Person");
			System.out.println("class found");
		}catch(ClassNotFoundException c) {
			System.out.println("cla"
					+ "ss not found");
		}catch(CloneNotSupportedException c2) {
			System.out.println("clone not supported");
		}*/
		//USING NESTED TRY CATCH BLOCKSS
		try {
			Object p2=p1.clone();
			System.out.println("clone is been executed");
			try {
				Class c1=Class.forName("checkedException.Person");
				System.out.println("class found");
			}catch(ClassNotFoundException c) {
				System.out.println("class not found");
			}
		}catch(CloneNotSupportedException c2) {
				System.out.println("clone not supported");
			}
	}
}
