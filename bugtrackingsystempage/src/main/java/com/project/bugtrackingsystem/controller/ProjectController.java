package com.project.bugtrackingsystem.controller;


import com.project.bugtrackingsystem.dto.ProjectDTO;
import com.project.bugtrackingsystem.service.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

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

	@GetMapping("/all")
	public Page<ProjectDTO> getAllProjects() {
		Pageable pageable = PageRequest.of(0, 10);
		Page<ProjectDTO> page = projectService.getAllProjects(pageable);
		return page;
	}
}
