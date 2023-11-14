package com.project.bugtrackingsystem.service;

import com.project.bugtrackingsystem.dto.DeveloperDTO;

import com.project.bugtrackingsystem.dto.ProjectDTO;
import com.project.bugtrackingsystem.dto.TestEngineerDTO;
//import com.project.bugtrackingsystem.entity.Developer;
import com.project.bugtrackingsystem.entity.Project;
//import com.project.bugtrackingsystem.entity.TestEngineer;
import com.project.bugtrackingsystem.entity.User;
//import com.project.bugtrackingsystem.repository.DeveloperRepository;
import com.project.bugtrackingsystem.repository.ProjectRepository;
//import com.project.bugtrackingsystem.repository.TestEngineerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

//    @Autowired
//    private DeveloperRepository developerRepository;
//
//    @Autowired
//    private TestEngineerRepository testEngineerRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProjectDTO createProject(ProjectDTO projDTO) {
        Project project = modelMapper.map(projDTO, Project.class);
        project = projectRepository.save(project);
        return modelMapper.map(project, ProjectDTO.class);
    }

    @Override
    public ProjectDTO getProjectById(Integer projId) {
        Project projectEntity = projectRepository.findById(projId).orElse(null);

        if (projectEntity != null) {
            return modelMapper.map(projectEntity, ProjectDTO.class);
        } else {
            return null; // Handle the case where the project is not found
        }
    }

    @Override
    public List<ProjectDTO> getAllProjects() {
        List<Project> projectEntities = projectRepository.findAll();

        return projectEntities.stream()
                .map(proj -> modelMapper.map(proj, ProjectDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ProjectDTO updateProject(ProjectDTO projDTO) {
        Project existingProjectEntity = projectRepository.findById(projDTO.getProjId()).orElse(null);

        if (existingProjectEntity != null) {
            // Update the fields as needed
            existingProjectEntity.setProjName(projDTO.getProjName());
            
            // Continue updating other fields

            existingProjectEntity = projectRepository.save(existingProjectEntity);
            return modelMapper.map(existingProjectEntity, ProjectDTO.class);
        } else {
            return null; // Handle the case where the project is not found
        }
    }

    @Override
    public List<DeveloperDTO> getDevelopersByProjectId(Integer projId) {
        Project projectEntity = projectRepository.findById(projId).orElse(null);

        if (projectEntity != null) {
            List<User> developersForProject = projectEntity.getUsers();

            return developersForProject.stream()
            		.filter(user1-> user1.getUserRole().equalsIgnoreCase("Dev"))
                    .map(developer -> modelMapper.map(developer, DeveloperDTO.class))
                    .collect(Collectors.toList());
        } else {
            return null; // Handle the case where the project is not found
        }
    }

    @Override
    public List<TestEngineerDTO> getTestEngineersByProjectId(Integer projId) {
    	 Project projectEntity = projectRepository.findById(projId).orElse(null);

         if (projectEntity != null) {
             List<User> developersForProject = projectEntity.getUsers();

             return developersForProject.stream()
             		.filter(user1-> user1.getUserRole().equalsIgnoreCase("Testing"))
                     .map(developer -> modelMapper.map(developer, TestEngineerDTO.class))
                     .collect(Collectors.toList());
         } else {
             return null; // Handle the case where the project is not found
         }
    }
}
