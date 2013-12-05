package com.linkedin.sample;

public class PersonDetails {
	
	private String _total;
	private PersonInfo values[]=new PersonInfo[100];
	public String getTotal() {
		return _total;
	}
	public void setTotal(String total) {
		this._total = total;
	}
	public PersonInfo[] getValues() {
		return values;
	}
	public void setValues(PersonInfo values[]) {
		this.values = values;
	}
	

}
