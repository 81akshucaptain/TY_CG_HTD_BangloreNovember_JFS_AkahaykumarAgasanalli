package jsp;

public class StaticExample {
	public static void main(String args[])
	{
		Qjsp BTM=new Qjsp();
		BTM.swipe();
		BTM.swipe();
		System.out.println("JSP BTM LAOUT STUDENTS IS:"+BTM.jsp);
		Qjsp RJJ=new Qjsp();
		RJJ.swipe();
		System.out.println("qsp BTM LAOUT STUDENTS IS:"+RJJ.qsp);

		System.out.println("total STUDENTS IS:"+Qjsp.testyantra);

	}

}
