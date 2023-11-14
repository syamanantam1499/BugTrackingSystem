package com.project.bugtrackingsystem.service;

import com.project.bugtrackingsystem.dto.DeveloperDTO;
import com.project.bugtrackingsystem.dto.ProjectDTO;
import java.util.List;


public interface DeveloperService {
    DeveloperDTO addDeveloper(DeveloperDTO developer);
    DeveloperDTO updateDeveloper(DeveloperDTO developer);
    DeveloperDTO getDeveloperById(Integer devId);
    List<DeveloperDTO> getAllDevelopers();
    List<ProjectDTO> getProjectsByDevId(Integer devId);
}
