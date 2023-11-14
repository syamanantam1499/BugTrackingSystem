package com.project.bugtrackingsystem.service;

//import com.project.bugtrackingsystem.dto.ProjectDTO;

import com.project.bugtrackingsystem.dto.TestEngineerDTO;
 
import java.util.List;
 
public interface TestEngineerService {
    TestEngineerDTO addTestEngineer(TestEngineerDTO testEngineer);
 
    TestEngineerDTO updateTestEngineer(TestEngineerDTO testEngineer);
 
    TestEngineerDTO getTestEngById(Integer testerId);
 
    List<TestEngineerDTO> getAllTesters();
 
//    List<ProjectDTO> getProjectsByTestEngId(Integer testEngId);
}