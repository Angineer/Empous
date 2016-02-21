package main.java.com.adtme.empous;

@SuppressWarnings("serial")
public class Commercial extends Capital{
	private int jobs;
	public Commercial(){
		super("Commercial", 1, 0, 50, 100, 150, 10, 25, 40, 12, 100, 65, 85, 110, 20, 30, 40, 12, 24, 37); //Use super constructor
	}
	
	public int getJobs(){
		return jobs;
	}
}
