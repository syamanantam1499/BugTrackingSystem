package com.project.bugtrackingsystem.entity;

import java.util.List;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING, length = 20)
@DiscriminatorValue("user_id") // Add this line to specify the discriminator value for the User class
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "username", unique = true)
    private String userName;

    @Column(name = "password")
    private String userPassword;

    @Column(name = "email")
    private String userEmail;

    @Column(name = "user_contact")
    private String userContact; 

    @Column(name = "user_role")
    private String userRole;
    
    @ManyToMany(mappedBy = "users")
    private List<Project> projects;
    // Constructors
    public User() {
    }

  

    public User(Integer userId, String userName, String userPassword, String userEmail, String userContact,
			String userRole, List<Project> projects) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userContact = userContact;
		this.userRole = userRole;
		this.projects = projects;
	}



	// Getters and Setters
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserContact() {
        return userContact;
    }

    public void setUserContact(String userContact) {
        this.userContact = userContact;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }



	public List<Project> getProjects() {
		return projects;
	}



	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}



	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPassword=" + userPassword + ", userEmail="
				+ userEmail + ", userContact=" + userContact + ", userRole=" + userRole + ", projects=" + projects
				+ "]";
	}

   
    
}
