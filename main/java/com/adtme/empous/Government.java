package main.java.com.adtme.empous;

import java.io.Serializable;
import java.util.HashMap;

@SuppressWarnings("serial")
public class Government implements Serializable{
	private HashMap<String, Integer> govDB = new HashMap<String, Integer>();
	private boolean riotState = false;
	private boolean mj = false;
	
	public Government(){
		govDB.put("reserve", 5000);
		govDB.put("woodstock", 500);
		govDB.put("oiltank", 500);
		govDB.put("census", 450);
		govDB.put("publicopinion", 65);
		govDB.put("employment", 225);
		govDB.put("freedom", 5); // 1
		govDB.put("military", 5);
		govDB.put("taxes", 5);
		govDB.put("education", 5);
		govDB.put("infrastructure", 5);
		govDB.put("environment", 5);
		govDB.put("sciencetech", 5);
		govDB.put("healthcare", 5);
		govDB.put("admin", 5);
	}	
	
	public int getStat(String stat){
		return govDB.get(stat);
	}
	
	public void setStat(String stat, int value){
		govDB.put(stat, value);
	}
	public boolean getMJ(){
		return mj;
	}
	public void setMJ(boolean value){
		mj=value;
	}
	public boolean getRiot(){
		return riotState;
	}
	public void setRiot(boolean value){
		riotState=value;
	}
}
