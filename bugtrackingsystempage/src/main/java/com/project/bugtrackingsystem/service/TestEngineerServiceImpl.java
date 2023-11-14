package com.project.bugtrackingsystem.service;
import com.project.bugtrackingsystem.dto.TestEngineerDTO;

import com.project.bugtrackingsystem.entity.TestEngineer;

import com.project.bugtrackingsystem.repository.TestEngineerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TestEngineerServiceImpl implements TestEngineerService {

    @Autowired
    private TestEngineerRepository testEngineerRepository;
    
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TestEngineerDTO addTestEngineer(TestEngineerDTO testEngineerDTO) {
        TestEngineer testEngineer = modelMapper.map(testEngineerDTO, TestEngineer.class);
        testEngineer = testEngineerRepository.save(testEngineer);
        return modelMapper.map(testEngineer, TestEngineerDTO.class);
    }

    @Override
    public TestEngineerDTO updateTestEngineer(TestEngineerDTO testEngineerDTO) {
        TestEngineer existingTestEngineerEntity = testEngineerRepository.findById(testEngineerDTO.getUserId()).orElse(null);

        if (existingTestEngineerEntity != null) {
            // Update the fields as needed
            existingTestEngineerEntity.setTesterName(testEngineerDTO.getTesterName());
            existingTestEngineerEntity.setUserEmail(testEngineerDTO.getUserEmail());
            
            // Continue updating other fields
            existingTestEngineerEntity = testEngineerRepository.save(existingTestEngineerEntity);
            return modelMapper.map(existingTestEngineerEntity, TestEngineerDTO.class);
        } else {
            return null; // Handle the case where the test engineer is not found
        }
    }

    @Override
    public TestEngineerDTO getTestEngById(Integer testerId) {
        TestEngineer testEngineerEntity = testEngineerRepository.findById(testerId).orElse(null);

        if (testEngineerEntity != null) {
            return modelMapper.map(testEngineerEntity, TestEngineerDTO.class);
        } else {
            return null; // Handle the case where the test engineer is not found
        }
    }

    @Override
    public Page<TestEngineerDTO> getAllTesters(Pageable pageable) {
    	Page<TestEngineer> testEngineerEntities = testEngineerRepository.findAll(pageable);
    	
    	Page<TestEngineerDTO> testEngineerDtoPage = testEngineerEntities.map(te -> modelMapper.map(te, TestEngineerDTO.class));
		return testEngineerDtoPage;
    }

    @Override
	public void deleteTestEngineer(Integer testerId) {
		
//		TestEngineer testEngineerEntity = modelMapper.map(testerId, TestEngineer.class);
		
		testEngineerRepository.deleteById(testerId);
	}
}
