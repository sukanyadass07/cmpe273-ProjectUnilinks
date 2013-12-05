package edu.sjsu.cmpe.unilinks_procurement_service;

public class DepartmentObject {
	
	String DepartmentName = null;
	int toeflscore = 0;
	int grescore = 0;
	int ieltscore = 0;
	public String getDepartmentName() {
		return DepartmentName;
	}
	public void setDepartmentName(String departmentName) {
		DepartmentName = departmentName;
	}
	public int getToeflscore() {
		return toeflscore;
	}
	public void setToeflscore(int toeflscore) {
		this.toeflscore = toeflscore;
	}
	public int getGrescore() {
		return grescore;
	}
	public void setGrescore(int grescore) {
		this.grescore = grescore;
	}
	public int getIeltscore() {
		return ieltscore;
	}
	public void setIeltscore(int ieltscore) {
		this.ieltscore = ieltscore;
	}
	
		

}
