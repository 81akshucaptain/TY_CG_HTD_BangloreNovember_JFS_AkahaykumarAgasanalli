package sppractice.tcs;
import java.util.ListResourceBundle;
import java.util.Objects;

public class SimpleForBundleEx extends ListResourceBundle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object[][] getContents() {
		return contents;
	}
	
	 static final Object[][] contents = { { "colour.Violet", "Violet" },  
	            { "colour.Indigo", "Indigo" }, { "colour.Blue", "Blue" }, };  
	}  