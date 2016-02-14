package main.java.com.adtme.empous;

@SuppressWarnings("serial")
public class Industrial extends Capital {
	private int jobs;
	public Industrial() {
		super(2, 0, 50, 100, 150, 10, 25, 40, 12, 100, 65, 85, 110, 20, 30, 40, 12, 24, 37); //Use super constructor
	}
	
	public int getJobs(){
		return jobs;
	}
}
