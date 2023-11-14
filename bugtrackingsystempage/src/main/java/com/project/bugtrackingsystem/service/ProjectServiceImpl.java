package com.project.bugtrackingsystem.service;

import com.project.bugtrackingsystem.dto.BugDTO;
import com.project.bugtrackingsystem.dto.DeveloperDTO;

import com.project.bugtrackingsystem.dto.ProjectDTO;
import com.project.bugtrackingsystem.dto.TestEngineerDTO;
import com.project.bugtrackingsystem.entity.Bug;
import com.project.bugtrackingsystem.entity.Project;
import com.project.bugtrackingsystem.entity.User;
import com.project.bugtrackingsystem.exception.BugException;
import com.project.bugtrackingsystem.exception.ProjectException;
import com.project.bugtrackingsystem.repository.ProjectRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProjectDTO createProject(ProjectDTO projDTO) {
        Project project = modelMapper.map(projDTO, Project.class);
        project = projectRepository.save(project);
        return modelMapper.map(project, ProjectDTO.class);
    }

    @Override
    public ProjectDTO getProjectById(Integer projId)
    {
        Project projectEntity = projectRepository.findById(projId).orElse(null);
 
        if (projectEntity != null) {
            return modelMapper.map(projectEntity, ProjectDTO.class);
        } else {
            // If the project is not found, throw a ProjectException or handle it accordingly
            throw new ProjectException("Project not found with id"+projId);
        }
    }

    @Override
    public Page<ProjectDTO> getAllProjects(Pageable pageable) {
    	Page<Project> projectEntities = projectRepository.findAll(pageable);
    	
    	Page<ProjectDTO> projectDtoPage = projectEntities.map(pj -> modelMapper.map(pj, ProjectDTO.class));
		return projectDtoPage;
    }

}
