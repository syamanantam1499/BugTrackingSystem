package com.project.bugtrackingsystem.entity;

import java.time.LocalDate;
import javax.persistence.*;

import com.project.bugtrackingsystem.util.BugStatus;
import com.project.bugtrackingsystem.util.Severity;

@Entity
@Table(name = "bugs")
public class Bug {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bug_id")
	private Integer bugId;

    @Column(name = "bug_title")
    private String bugTitle;

    @Column(name = "bug_description")
    private String bugDescription;

    @Enumerated(EnumType.STRING)
    @Column(name = "severity")
    private Severity severity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "created_by_id", referencedColumnName = "user_id")
    private TestEngineer createdBy;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "assign_to_id", referencedColumnName = "user_id")
    private Developer assignTo;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private BugStatus status;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "last_updated_date")
    private LocalDate lastUpdatedDate;

    @ManyToOne
    @JoinColumn(name = "proj_id")
    private Project project;

    // Constructors
    public Bug() {
    }

    public Bug(String bugTitle, String bugDescription, Severity severity, TestEngineer createdBy, Developer assignTo, BugStatus status, LocalDate startDate, LocalDate lastUpdatedDate, Project project) {
        this.bugTitle = bugTitle;
        this.bugDescription = bugDescription;
        this.severity = severity;
        this.createdBy = createdBy;
        this.assignTo = assignTo;
        this.status = status;
        this.startDate = startDate;
        this.lastUpdatedDate = lastUpdatedDate;
        this.project = project;
    }

    // Getters and setters
    public Integer getBugId() {
        return bugId;
    }

    public void setBugId(Integer bugId) {
        this.bugId = bugId;
    }

    public String getBugTitle() {
        return bugTitle;
    }

    public void setBugTitle(String bugTitle) {
        this.bugTitle = bugTitle;
    }

    public String getBugDescription() {
        return bugDescription;
    }

    public void setBugDescription(String bugDescription) {
        this.bugDescription = bugDescription;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public TestEngineer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(TestEngineer createdBy) {
        this.createdBy = createdBy;
    }

    public Developer getAssignTo() {
        return assignTo;
    }

    public void setAssignTo(Developer assignTo) {
        this.assignTo = assignTo;
    }

    public BugStatus getStatus() {
        return status;
    }

    public void setStatus(BugStatus status) {
        this.status = status;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(LocalDate lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "Bug{" +
                "bugId=" + bugId +
                ", bugTitle='" + bugTitle + '\'' +
                ", bugDescription='" + bugDescription + '\'' +
                ", severity=" + severity +
                ", createdBy=" + createdBy +
                ", assignTo=" + assignTo +
                ", status=" + status +
                ", startDate=" + startDate +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", project=" + project +
                '}';
    }

}
