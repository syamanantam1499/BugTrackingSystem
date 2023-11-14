package com.project.bugtrackingsystem.controller;

import com.project.bugtrackingsystem.dto.BugDTO;
import com.project.bugtrackingsystem.dto.TestEngineerDTO;
import com.project.bugtrackingsystem.service.BugServiceImpl;
import com.project.bugtrackingsystem.util.BugStatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/bugs")
public class BugController {

	@Autowired
	private BugServiceImpl bugService;


	@PostMapping("/create")
	public BugDTO createBug(@RequestBody BugDTO bugDTO) {
		return bugService.createBug(bugDTO);
	}

	@PutMapping("/update")
	public BugDTO updateBug(@RequestBody BugDTO bugDTO) {
		return bugService.updateBug(bugDTO);
	}

	@GetMapping("/{id}")
	public BugDTO findBugById(@PathVariable Integer id) {
		return bugService.findBugById(id);
	}

	@GetMapping("/all")
	public List<BugDTO> findAllBugs() {
		return bugService.findAllBugs();
	}

	@GetMapping("/byProject/{projectId}")
	public List<BugDTO> findBugsByProjectId(@PathVariable Integer projectId) {
		return bugService.findAllBugsByProjectId(projectId);
	}

//	@GetMapping("/byDeveloper/{userId}")
//	public List<BugDTO> findBugsAssignedToDeveloper(@PathVariable Integer userId) {
//		return bugService.findBugsAssignedToDeveloper(userId);
//	}

	@GetMapping("/byStatus/{status}")
	public List<BugDTO> findBugsByStatus(@PathVariable BugStatus status) {
		return bugService.findBugsByStatus(status);
	}

	@GetMapping("/bySeverity/{severity}")
	public List<BugDTO> findBugsBySeverity(@PathVariable String severity) {
		return bugService.findBugsBySeverity(severity);
	}

	@GetMapping("/byDate/{date}")
	public List<BugDTO> findBugsByDate(@PathVariable LocalDate date) {
		return bugService.findBugsByDate(date);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteBugById(@PathVariable Integer id) {
		// Implement logic to delete the bug by ID
		return "Bug with ID " + id + " deleted successfully";
	}
	
//	@GetMapping("/byTestEngineer/{userId}")
//	public List<BugDTO> findBugsCreatedByTestEngineer(@PathVariable Integer userId) {
//		return bugService.findBugsCreatedByTestEngineer(userId);
//	}
}