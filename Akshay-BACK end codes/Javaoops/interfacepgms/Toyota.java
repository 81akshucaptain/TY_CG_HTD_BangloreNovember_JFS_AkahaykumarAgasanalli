package interfacepgms;

public interface Toyota {
	//we can add the concrete method only by using DEFAULT keyword 
default void concrete() {
		System.out.println("");
	}
double cost=30000;
void design();
void engine();
}
