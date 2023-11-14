package com.project.bugtrackingsystem.service;

import java.util.List;

import com.project.bugtrackingsystem.dto.DeveloperDTO;
import com.project.bugtrackingsystem.dto.ProjectDTO;
import com.project.bugtrackingsystem.dto.TestEngineerDTO;

public interface ProjectService {

    ProjectDTO createProject(ProjectDTO projDTO);

    ProjectDTO getProjectById(Integer projId);

    List<ProjectDTO> getAllProjects();

    ProjectDTO updateProject(ProjectDTO projDTO);

    List<DeveloperDTO> getDevelopersByProjectId(Integer projId);

    List<TestEngineerDTO> getTestEngineersByProjectId(Integer projId);
}
