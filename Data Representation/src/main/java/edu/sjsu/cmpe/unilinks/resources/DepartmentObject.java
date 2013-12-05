package edu.sjsu.cmpe.unilinks.resources;

import org.codehaus.jackson.annotate.JsonProperty;

public class DepartmentObject {
    @JsonProperty("DepartmentName")
    String DepartmentName;
    @JsonProperty("toeflscore")
    int toeflscore;
    @JsonProperty("grescore")
    int grescore;
    @JsonProperty("ieltsscore")
    int ieltscore;
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
