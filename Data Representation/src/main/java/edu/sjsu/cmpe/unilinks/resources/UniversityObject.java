package edu.sjsu.cmpe.unilinks.resources;
import java.util.ArrayList;
import org.codehaus.jackson.annotate.JsonProperty;

public class UniversityObject {
    @JsonProperty("_id")
    int _id = 0;    
    @JsonProperty("SchoolName")
    String SchoolName;
    @JsonProperty("department")
    ArrayList<DepartmentObject> department = new ArrayList<DepartmentObject>();
    @JsonProperty("location")
    String location;
    @JsonProperty("tutionFees")
    int tutionFees = 0;
    @JsonProperty("FallApplnDate")
    String FallApplnDate;
    @JsonProperty("SpringApplnDate")
    String SpringApplnDate;
    @JsonProperty("contactInfo")
    String contactInfo;
    public int getId() {
    return _id;
    }
    public void setId(int id) {
    this._id = id;
    }
    

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
    public String getSchoolName() {
    return SchoolName;
    }
    public void setSchoolName(String SchoolName) {
    this.SchoolName = SchoolName;
    }
    public String getLocation() {
    return location;
    }
    public void setLocation(String location) {
    this.location = location;
    }

}