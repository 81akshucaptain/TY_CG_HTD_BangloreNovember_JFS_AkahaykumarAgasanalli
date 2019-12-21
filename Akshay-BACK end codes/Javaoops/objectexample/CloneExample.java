package objectexample;

public class CloneExample implements Cloneable {
	String name;
	public CloneExample(String name) {
		super();
		this.name = name;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	

}
