package com.project.bugtrackingsystem.dto;

import java.util.List;

import javax.persistence.Entity;

//@Entity
public class TestEngineerDTO extends UserDTO {
	
	private String testerName;
	private String testerSkill;
//	private List<ProjectDTO> project;
	
	public TestEngineerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TestEngineerDTO(Integer userId, String userName, String userPassword, String userEmail, String userContact,
			String userRole,String testerName, String testerSkill, List<ProjectDTO> project) {
		super(userId, userName, userPassword, userEmail, userContact, userRole);
		this.testerName = testerName;
		this.testerSkill = testerSkill;
//		this.project = project;
	}
	
	
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
//	public List<ProjectDTO> getProject() {
//		return project;
//	}
//	public void setProject(List<ProjectDTO> project) {
//		this.project = project;
//	}
	
	
}
