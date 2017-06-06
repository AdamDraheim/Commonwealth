package commonwealth.ser;

import java.io.Serializable;
import java.util.LinkedList;

import commonwealth.issues.Issues;
import commonwealth.nations.Nations;

public class fileInfo implements Serializable{

	String name;
	LinkedList<Nations> nations;
	int year;
	int month;
	boolean constitution, judge, leader;
	
	public fileInfo(String name, LinkedList<Nations> nations, int year, int month, boolean constitution, boolean judge, boolean leader){
		
		this.name = name;
		this.nations = nations;
		this.year = year;
		this.month = month;
		this.constitution = constitution;
		this.judge = judge;
		this.leader = leader;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LinkedList<Nations> getNations() {
		return nations;
	}

	public void setNations(LinkedList<Nations> nations) {
		this.nations = nations;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public boolean isConstitution() {
		return constitution;
	}

	public void setConstitution(boolean constitution) {
		this.constitution = constitution;
	}

	public boolean isJudge() {
		return judge;
	}

	public void setJudge(boolean judge) {
		this.judge = judge;
	}

	public boolean isLeader() {
		return leader;
	}

	public void setLeader(boolean leader) {
		this.leader = leader;
	}
	
	
	
}
