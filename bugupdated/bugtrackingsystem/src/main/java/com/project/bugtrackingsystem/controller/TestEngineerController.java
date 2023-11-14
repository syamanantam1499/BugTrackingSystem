package com.project.bugtrackingsystem.controller;

//import com.project.bugtrackingsystem.dto.ProjectDTO;
import com.project.bugtrackingsystem.dto.TestEngineerDTO;
import com.project.bugtrackingsystem.service.TestEngineerServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testengineers")
public class TestEngineerController {

	@Autowired
	private TestEngineerServiceImpl testEngineerService;


	@PostMapping("/add")
	public TestEngineerDTO addTestEngineer(@RequestBody TestEngineerDTO testEngineerDTO) {
		testEngineerDTO.setUserRole("TestEngineer");
		return testEngineerService.addTestEngineer(testEngineerDTO);
	}

	@PutMapping("/update")
	public TestEngineerDTO updateTestEngineer(@RequestBody TestEngineerDTO testEngineerDTO) {
		return testEngineerService.updateTestEngineer(testEngineerDTO);
	}

	@GetMapping("/{id}")
	public TestEngineerDTO getTestEngineerById(@PathVariable Integer id) {
		return testEngineerService.getTestEngById(id);
	}

	@GetMapping("/all")
	public List<TestEngineerDTO> getAllTestEngineers() {
		return testEngineerService.getAllTesters();
	}

//	@GetMapping("/{id}/projects")
//	public List<ProjectDTO> getProjectsByTestEngineerId(@PathVariable Integer id) {
//		return testEngineerService.getProjectsByTestEngId(id);
//	}

	@DeleteMapping("/delete/{id}")
	public String deleteTestEngineer(@PathVariable Integer id) {
		// Implement logic to delete the test engineer by id
		return "Test engineer with ID " + id + " deleted successfully";
	}
}