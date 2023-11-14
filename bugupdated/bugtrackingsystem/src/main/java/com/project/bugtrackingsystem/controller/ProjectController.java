package com.project.bugtrackingsystem.controller;

import com.project.bugtrackingsystem.dto.DeveloperDTO;
import com.project.bugtrackingsystem.dto.ProjectDTO;
import com.project.bugtrackingsystem.dto.TestEngineerDTO;
import com.project.bugtrackingsystem.service.ProjectServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	private ProjectServiceImpl projectService;

	
	@PostMapping("/create")
	public ProjectDTO createProject(@RequestBody ProjectDTO projectDTO) {
		return projectService.createProject(projectDTO);
	}

	@GetMapping("/{id}")
	public ProjectDTO getProjectById(@PathVariable Integer id) {
		return projectService.getProjectById(id);
	}

	@GetMapping
	public List<ProjectDTO> getAllProjects() {
		return projectService.getAllProjects();
	}

	@PutMapping("/{id}")
	public ProjectDTO updateProject(@PathVariable Integer id, @RequestBody ProjectDTO projectDTO) {
		// Set the project ID before updating
		projectDTO.setProjId(id);
		return projectService.updateProject(projectDTO);
	}

	@GetMapping("/{id}/developers")
	public List<DeveloperDTO> getDevelopersByProjectId(@PathVariable Integer id) {
		return projectService.getDevelopersByProjectId(id);
	}

	@GetMapping("/{id}/test-engineers")
	public List<TestEngineerDTO> getTestEngineersByProjectId(@PathVariable Integer id) {
		return projectService.getTestEngineersByProjectId(id);
	}
}
