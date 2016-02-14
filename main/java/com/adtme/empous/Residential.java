package main.java.com.adtme.empous;

@SuppressWarnings("serial")
public class Residential extends Capital {
	private int pop;
	public Residential() {
		super(1, 4, 50, 100, 150, 10, 25, 40, 12, 100, 65, 85, 110, 20, 30, 40, 12, 24, 37); //Use super constructor
	}
	
	public int getPop(){
		return pop;
	}
}
