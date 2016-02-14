package main.java.com.adtme.empous;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Government implements Serializable{
	public int reserve = 5000;
	public int woodstock = 500;
	public int oiltank = 500;
	public int census = 450;
	public int publicopinion = 65;
	public int employment = 225;
	public int riotstate = 0;
	private int freedom=5;
	private int military=5;
	private int taxes=5;
	private int education=5;
	private int infrastructure=5;
	private int environment=5;
	private int sciencetech=5;
	private int healthcare=5;
	private int admin=5;
	private boolean mj=false;
	
	public int getGov(int stat){
		switch (stat){
		case 1: stat=freedom; break;
		case 2: stat=military; break;
		case 3: stat=taxes; break;
		case 4: stat=education; break;
		case 5: stat=infrastructure; break;
		case 6: stat=environment; break;
		case 7: stat=sciencetech; break;
		case 8: stat=healthcare; break;
		case 9: stat=admin; break;
		default: stat=0; break;
		}
		return stat;
	}
	
	public void setGov(int stat, int value){
		switch (stat){
		case 1: freedom=value; break;
		case 2: military=value; break;
		case 3: taxes=value; break;
		case 4: education=value; break;
		case 5: infrastructure=value; break;
		case 6: environment=value; break;
		case 7: sciencetech=value; break;
		case 8: healthcare=value; break;
		case 9: admin=value; break;
		default: break;
		}
	}
	public boolean getMJ(){
		return mj;
	}
	public void setMJ(boolean value){
		mj=value;
	}
}
