package com.project.bugtrackingsystem.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.project.bugtrackingsystem.dto.ProjectDTO;

public interface ProjectService {

    ProjectDTO createProject(ProjectDTO projDTO);
    ProjectDTO getProjectById(Integer projId);
    Page<ProjectDTO> getAllProjects(Pageable pageable);
}
