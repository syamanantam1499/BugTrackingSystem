package com.project.bugtrackingsystem.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("TestEngineer")
public class TestEngineer extends User {

	private String testerName;
	private String testerSkill;

	public TestEngineer() {
	}

	public TestEngineer(Integer userId, String userName, String userPassword, String userEmail, String userContact,
			String userRole, String testerName, String testerSkill,List<Project> projects) {
		super(userId, userName, userPassword, userEmail, userContact, userRole,projects);
		this.testerName = testerName;
		this.testerSkill = testerSkill;
	}

	// Getters and Setters
	public String getTesterName() {
		return testerName;
	}

	public void setTesterName(String testerName) {
		this.testerName = testerName;
	}

	public String getTesterSkill() {
		return testerSkill;
	}

	public void setTesterSkill(String testerSkill) {
		this.testerSkill = testerSkill;
	}

	@Override
	public String toString() {
		return "TestEngineer [testEngineerId=" + ", testerName=" + testerName + ", testerSkill="
				+ testerSkill + "]";
	}
	
}
