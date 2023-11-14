package com.project.bugtrackingsystem.service;

import com.project.bugtrackingsystem.dto.BugDTO;
import com.project.bugtrackingsystem.dto.TestEngineerDTO;
import com.project.bugtrackingsystem.util.BugStatus;

import java.time.LocalDate;
import java.util.List;
 
public interface BugService {
	
    public BugDTO createBug(BugDTO bugDTO);
    public BugDTO updateBug(BugDTO bugDTO);
    public BugDTO findBugById(Integer bugId);
    
    public List<BugDTO> findAllBugs();
    public List<BugDTO> findAllBugsByProjectId(Integer projId);
//    public List<BugDTO> findBugsAssignedToDeveloper(Integer userId);
    
//    public List<BugDTO> findBugsAssignedToDeveloperByStatus(Integer userId, String status);
    public List<BugDTO> findBugsByStatus(BugStatus status); 
    public List<BugDTO> findBugsBySeverity(String severity);
    public List<BugDTO> findBugsByDate(LocalDate date);
//    public List<BugDTO> findBugsByDevIdAndDate(Integer userId, LocalDate startDate, LocalDate endDate);
//    public List<BugDTO> findBugsByProjectIdAndDevId(Integer projId, Integer userId);
//    public List<BugDTO> findBugsByProjectIdAndTestEngId(Integer projId, Integer userId);
//	List<BugDTO> findBugsCreatedByTestEngineer(TestEngineerDTO userId);
}