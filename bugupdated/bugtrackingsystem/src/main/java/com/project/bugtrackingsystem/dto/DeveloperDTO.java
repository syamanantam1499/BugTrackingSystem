package com.project.bugtrackingsystem.dto;

import java.util.List;

public class DeveloperDTO extends UserDTO {
	
	private String devName;
	private String devSkill;
//	private List<ProjectDTO> project;
	public DeveloperDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DeveloperDTO(Integer userId, String userName, String userPassword, String userEmail, String userContact,String userRole,String devName, String devSkill, List<ProjectDTO> project) {
		super(userId, userName, userPassword, userEmail, userContact, userRole);
//		this.devId=userId;
		this.devName = devName;
		this.devSkill = devSkill;
//		this.project = project;
	}

//	public Integer getDevId() {
//		return devId;
//	}
//	public void setDevId(Integer devId) {
//		this.devId = devId;
//	}
	public String getDevName() {
		return devName;
	}
	public void setDevName(String devName) {
		this.devName = devName;
	}
	public String getDevSkill() {
		return devSkill;
	}
	public void setDevSkill(String devSkill) {
		this.devSkill = devSkill;
	}
//	public List<ProjectDTO> getProject() {
//		return project;
//	}
//	public void setProject(List<ProjectDTO> project) {
//		this.project = project;
//	}
}