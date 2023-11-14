package com.project.bugtrackingsystem.dto;

import java.util.List;

import com.project.bugtrackingsystem.entity.User;

public class ProjectDTO {

    private Integer projId;
    private String projName;
    private String projectDescription;
    private String projStatus;
    private List<User> users;

    // Constructors, getters, and setters

    public ProjectDTO() {
    	super();
    }

    public ProjectDTO(Integer projId, String projName, String projectDescription, String projStatus, List<User> users) {
        this.projId = projId;
        this.projName = projName;
        this.projectDescription = projectDescription;
        this.projStatus = projStatus;
        this.users=users;
    }
    
    

    public Integer getProjId() {
        return projId;
    }

    public void setProjId(Integer projId) {
        this.projId = projId;
    }

    public String getProjName() {
        return projName;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getProjStatus() {
        return projStatus;
    }

    public void setProjStatus(String projStatus) {
        this.projStatus = projStatus;
    }

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "ProjectDTO [projId=" + projId + ", projName=" + projName + ", projectDescription=" + projectDescription
				+ ", projStatus=" + projStatus + ", users=" + users + "]";
	}
    
 
}
