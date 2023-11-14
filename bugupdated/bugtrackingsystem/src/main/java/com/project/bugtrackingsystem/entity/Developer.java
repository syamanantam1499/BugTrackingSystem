package com.project.bugtrackingsystem.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Developer extends User {

    private String devName;
    private String devSkill;

    // Constructors
    public Developer() {
    }

    public Developer(Integer userId,String userName, String userPassword, String userEmail, String userContact, String userRole,
                     String devName, String devSkill, List<Project> projects) {
        super(userId,userName, userPassword, userEmail, userContact, userRole,projects);
        this.devName = devName;
        this.devSkill = devSkill;
    }

    // Getters and Setters
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

    @Override
    public String toString() {
        return "Developer{" +
                "devName='" + devName + '\'' +
                ", devSkill='" + devSkill + '\'' +
                
                "} " + super.toString();
    }
}
