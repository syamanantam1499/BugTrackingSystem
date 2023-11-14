package com.project.bugtrackingsystem.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "proj_id")
	private Integer projId;

	@Column(name = "proj_name")
	private String projName;

	@Column(name = "project_description")
	private String projectDescription;

	@Column(name = "proj_status")
	private String projStatus;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(name = "project_user",
            joinColumns = @JoinColumn(name = "proj_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;

	// Constructors
	public Project() {
		super();
	}

	

	public Project(Integer projId, String projName, String projectDescription, String projStatus,
			List<User> users) {
		super();
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
		return "Project [projId=" + projId + ", projName=" + projName + ", projectDescription=" + projectDescription
				+ ", projStatus=" + projStatus + ", users=" + users + "]";
	}

	



}