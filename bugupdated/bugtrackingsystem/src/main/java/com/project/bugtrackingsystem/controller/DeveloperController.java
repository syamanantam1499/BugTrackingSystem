package com.project.bugtrackingsystem.controller;

import com.project.bugtrackingsystem.dto.DeveloperDTO;

import com.project.bugtrackingsystem.dto.ProjectDTO;
import com.project.bugtrackingsystem.service.DeveloperServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/developers")
public class DeveloperController {

	@Autowired
	//@Qualifier("developerServiceImpl")
	private DeveloperServiceImpl developerService;


	@PostMapping("/add")
	public DeveloperDTO addDeveloper(@RequestBody DeveloperDTO developer) {
		return developerService.addDeveloper(developer);
	}

	@PutMapping("/")
	public DeveloperDTO updateDeveloper(@RequestBody DeveloperDTO developer) {
		return developerService.updateDeveloper(developer);
	}

	@GetMapping("/{devId}")
	public DeveloperDTO getDeveloperById(@PathVariable Integer devId) {
		return developerService.getDeveloperById(devId);
	}

	@GetMapping("/")
	public List<DeveloperDTO> getAllDevelopers() {
		return developerService.getAllDevelopers();
	}

	@GetMapping("/{devId}/projects")
	public List<ProjectDTO> getProjectsByDevId(@PathVariable Integer devId) {
		return developerService.getProjectsByDevId(devId);
	}
}