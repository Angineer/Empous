package main.java.com.adtme.empous;

import java.io.Serializable;

/** Buildings class
 * 
 * @author Andy2
 *
 */

@SuppressWarnings("serial")
public class Capital implements Serializable{
	private String type = "Capital";
	private int max_build, resource1, resource2, resource1_level, resource2_level; //Stats about the type of capital
	private int sgenrate1, mgenrate1, lgenrate1;
	private int sgenrate2, mgenrate2, lgenrate2;
	private int scapcost, mcapcost, lcapcost;
	private int swoodcost, mwoodcost, lwoodcost;
	private int soilcost, moilcost, loilcost;
	private int small, med, large; //Number of components of each size
	private double build_rate;
	private double build_level;
	
	public Capital(String type, int a1, int a2, int b1, int b2, int b3, int b4, int b5, int b6, double c, int d, 
			int e1, int e2, int e3,	int f1, int f2, int f3, int g1, int g2, int g3){	//Constructor
		this.type=type;
		resource1=a1;	//Set dynamic resource
		if (a2!=-1){	//Set proportional resource
			resource2=a2;	
		}
		sgenrate1=b1;
		mgenrate1=b1;
		lgenrate1=b3;
		sgenrate2=b4;
		mgenrate2=b5;
		lgenrate2=b6;
		build_rate=c;
		max_build=d;
		build_level=max_build;
		scapcost=e1;
		mcapcost=e2;
		lcapcost=e3;
		swoodcost=f1;
		mwoodcost=f2;
		lwoodcost=f3;
		soilcost=g1;
		moilcost=g2;
		loilcost=g3;
		small=1;
		med=1;
		large=1;
	}
	
	public void upkeep(){
		build_level+=(Empous.Gov.getGov(5)-7)*build_rate;
			
		if (build_level>max_build)
			build_level=max_build;
	}

	public int generate1(){ //Generate per-turn resources
		if (resource1==1){
			resource1_level=(sgenrate1*small+mgenrate1*med+lgenrate1*large)*Empous.Gov.getGov(3)/5
					-((Empous.Gov.getGov(1)*Empous.Gov.getGov(2)+1)*10
					+Empous.Gov.getGov(4)*10
					+Empous.Gov.getGov(5)*10
					+Empous.Gov.getGov(6)*5
					+Empous.Gov.getGov(7)*5
					+Empous.Gov.getGov(8)*15
					+Empous.Gov.getGov(9)*1);
		}
		else if (resource1==2){
			resource1_level=(sgenrate1*small+mgenrate1*med+lgenrate1*large)*
				(1+Empous.Gov.getGov(7)/100+Empous.Gov.getGov(2)/100);
		}
		else if (resource1==3){
			resource1_level=(sgenrate1*small+mgenrate1*med+lgenrate1*large)*
			(1+Empous.Gov.getGov(4)/100+Empous.Gov.getGov(6)/75);
		}
		return resource1_level;
	}
	public int generate2(){	//Calculate proportional resources
		resource2_level=sgenrate2*small+mgenrate2*med+lgenrate2*large;
		return resource2_level;
	}
	
	public int getSmall(){
		return small;
	}
	
	public int getMedium(){
		return med;
	}
	
	public int getLarge(){
		return large;
	}

	public int getJobs(int size){
		if (resource2==0){
			if (size==1){
				return sgenrate2;
			}
			else if (size==2){
				return mgenrate2;
			}
			else {
				return lgenrate2;
			}
		}
		else{
			return 0;
		}
	}
	public int getCap(int size){
		if (resource1==1){
			if (size==1){
				return sgenrate1;
			}
			else if (size==2){
				return mgenrate1;
			}
			else {
				return lgenrate1;
			}
		}
		else{
			return 0;
		}
	}
	public int getOil(int size){
		if (resource1==2){
			if (size==1){
				return sgenrate1;
			}
			else if (size==2){
				return mgenrate1;
			}
			else {
				return lgenrate1;
			}
		}
		else{
			return 0;
		}
	}
	public int getWood(int size){
		if (resource1==3){
			if (size==1){
				return sgenrate1;
			}
			else if (size==2){
				return mgenrate1;
			}
			else {
				return lgenrate1;
			}
		}
		else{
			return 0;
		}
	}
	public int getPop(int size){
		if (resource2==4){
			if (size==1){
				return sgenrate2;
			}
			else if (size==2){
				return mgenrate2;
			}
			else {
				return lgenrate2;
			}
		}
		else{
			return 0;
		}
	}


	public double getMaxBuild(){
		return max_build;
	}
	public void setBuildRate(double newRate){
		build_rate=newRate;
	}
	public double getBuildRate(){
		return build_rate;
	}
	public void setBuildLevel(double newLevel){
		build_level=newLevel;
	}
	public double getBuildLevel(){
		return build_level;
	}
	public String getType(){
		return type;
	}
}
