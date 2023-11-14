package com.project.bugtrackingsystem.service;


import com.project.bugtrackingsystem.dto.TestEngineerDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
 
public interface TestEngineerService {
    TestEngineerDTO addTestEngineer(TestEngineerDTO testEngineer);
    TestEngineerDTO updateTestEngineer(TestEngineerDTO testEngineer);
    TestEngineerDTO getTestEngById(Integer testerId);
    Page<TestEngineerDTO> getAllTesters(Pageable pageable);
	void deleteTestEngineer(Integer testerId);
}