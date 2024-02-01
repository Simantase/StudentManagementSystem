package com.jsp.student.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import org.springframework.stereotype.Component;
@Component
@Entity
public class Student {
	@Id
	private int sId;
	private String sName;
	private int sMarks;
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public int getsMarks() {
		return sMarks;
	}
	public void setsMarks(int sMarks) {
		this.sMarks = sMarks;
	}
	@Override
	public String toString() {
		return "Student [sId=" + sId + ", sName=" + sName + ", sMarks=" + sMarks + "]";
	}
}
