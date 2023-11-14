package com.project.bugtrackingsystem.controller;
import com.project.bugtrackingsystem.dto.DeveloperDTO;

import com.project.bugtrackingsystem.dto.ProjectDTO;
import com.project.bugtrackingsystem.service.DeveloperServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/developers")
public class DeveloperController {

	@Autowired
	private DeveloperServiceImpl developerService;


	@PostMapping("/add")
	public DeveloperDTO addDeveloper(@RequestBody DeveloperDTO developer) {
		return developerService.addDeveloper(developer);
	}

	@GetMapping("/{devId}")
	public DeveloperDTO getDeveloperById(@PathVariable Integer devId) {
		return developerService.getDeveloperById(devId);
	}
	
	@GetMapping("/all")
	public Page<DeveloperDTO> getAllDevelopers() {
		Pageable pageable = PageRequest.of(0, 10);
		Page<DeveloperDTO> page = developerService.getAllDevelopers(pageable);
		return page;
	}
	
	@DeleteMapping("/delete/{devId}")
	public void deleteDeveloper(@PathVariable Integer devId) {
		developerService.deleteDeveloper(devId);
		System.out.println("Bug with ID " + devId + " deleted successfully");
	}
}