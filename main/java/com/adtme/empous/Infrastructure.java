package main.java.com.adtme.empous;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Infrastructure implements Serializable{
	private int max_level=100, level, repair_rate;
	
	public int getLevel(){
		return level;
	}
	public int getMaxLevel(){
		return max_level;
	}
	public void upkeep(){
		level+=(Empous.Gov.getGov(5)-7)*repair_rate;
		
		if (level>max_level)
			level=max_level;
	}
}
