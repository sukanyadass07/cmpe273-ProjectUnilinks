package edu.sjsu.cmpe.unilinks_procurement_service;
import edu.sjsu.cmpe.unilinks_procurement_service.DepartmentObject;
import java.util.ArrayList;
public class UniversityObject {
	
int id = 0;	
String name = new String();
ArrayList<DepartmentObject> department = new ArrayList<DepartmentObject>();
String location = new String();
int tutionFees = 0;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
String FallApplnDate = new String();
String SpringApplnDate = new String();


String contactInfo = new String();





public int getTutionFees() {
	return tutionFees;
}
public void setTutionFees(int tutionFees) {
	this.tutionFees = tutionFees;
}
public String getFallApplnDate() {
	return FallApplnDate;
}
public void setFallApplnDate(String fallApplnDate) {
	FallApplnDate = fallApplnDate;
}
public String getSpringApplnDate() {
	return SpringApplnDate;
}
public void setSpringApplnDate(String springApplnDate) {
	SpringApplnDate = springApplnDate;
}
public String getContactInfo() {
	return contactInfo;
}
public void setContactInfo(String contactInfo) {
	this.contactInfo = contactInfo;
}
public ArrayList<DepartmentObject> getDepartment() {
	return department;
}
public void setDepartment(ArrayList<DepartmentObject> department) {
	this.department = department;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}

	

}
