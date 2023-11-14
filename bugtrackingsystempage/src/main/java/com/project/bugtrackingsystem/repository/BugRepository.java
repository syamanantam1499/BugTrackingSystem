package com.project.bugtrackingsystem.repository;

import com.project.bugtrackingsystem.entity.Bug;
import com.project.bugtrackingsystem.util.BugStatus;
import com.project.bugtrackingsystem.util.Severity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
 
@Repository
public interface BugRepository extends JpaRepository<Bug, Integer> {
    
	@Query("select b from Bug b where b.project.projId = ?1")
	List<Bug> findByProject(Integer projId);
	
	List<Bug> findByStatus(BugStatus status);
	List<Bug> findBySeverity(Severity severity);
}