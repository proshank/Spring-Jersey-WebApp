package com.proshank.employee.data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {
	private String firstName;
	private String lastName;
	private String cec;
	private String password;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCec() {
		return cec;
	}

	public void setCec(String cec) {
		this.cec = cec;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
	}

	public void initializeDummy() {
		this.firstName = "Pawan";
		this.lastName = "Roshankhede";
		this.cec = "proshank";
		this.password = "proshank";
	}

}
