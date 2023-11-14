package com.project.bugtrackingsystem.repository;

import com.project.bugtrackingsystem.entity.Bug;
import com.project.bugtrackingsystem.util.BugStatus;
import com.project.bugtrackingsystem.util.Severity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
 
@Repository
public interface BugRepository extends JpaRepository<Bug, Integer> {

    List<Bug> findByStatus(BugStatus status);
    List<Bug> findBySeverity(Severity severity);
    void deleteByStatus(BugStatus status);
    void deleteBySeverity(Severity severity);
	List<Bug> findAllByProjectProjId(Integer projId);
//	List<Bug> findAllByAssignToDevId(Integer userId);
//	List<Bug> findAllByAssignToDevIdAndStatus(Integer userId, String status);
	List<Bug> findAllByStatus(BugStatus status);
	List<Bug> findAllBySeverity(String severity);
	List<Bug> findAllByStartDate(LocalDate date);
//	List<Bug> findAllByAssignToDevIdAndStartDateBetween(Integer userId, LocalDate startDate, LocalDate endDate);
//	List<Bug> findAllByCreatedByTestEngineerId(Integer userId);
//	List<Bug> findAllByProjectProjIdAndAssignToDevId(Integer projId, Integer userId);
//	List<Bug> findAllByProjectProjIdAndCreatedByTestEngineerId(Integer projId, Integer userId);
    
}