package com.project.bugtrackingsystem.service;

import com.project.bugtrackingsystem.dto.DeveloperDTO;
import com.project.bugtrackingsystem.dto.ProjectDTO;
import com.project.bugtrackingsystem.entity.Developer;
import com.project.bugtrackingsystem.entity.Project;
import com.project.bugtrackingsystem.repository.DeveloperRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeveloperServiceImpl implements DeveloperService {
	
	@Autowired
	private DeveloperRepository developerRepository;
	
	@Autowired
    private ModelMapper modelMapper;
	
	

	@Override
	public DeveloperDTO addDeveloper(DeveloperDTO developerDTO) {
		// Map the DeveloperDTO to an entity, save it to the database, and return the
		// saved entity as a DTO
		Developer developer = modelMapper.map(developerDTO, Developer.class);
        developer = developerRepository.save(developer);
        return modelMapper.map(developer, DeveloperDTO.class);
		
	}

	@Override
	public DeveloperDTO getDeveloperById(Integer devId) {
		// Retrieve the developer entity by ID from the database
		Developer developerEntity = modelMapper.map(devId, Developer.class);
		developerEntity = developerRepository.findById(devId).orElse(null);
		if (developerEntity != null) {
			// Map the entity to a DTO and return it
			return modelMapper.map(developerEntity, DeveloperDTO.class);
		} else {
			// Handle the case where the developer is not found
			return null;
		}
	}

	@Override
	public Page<DeveloperDTO> getAllDevelopers(Pageable pageable) {
		Page<Developer> developerEntities = developerRepository.findAll(pageable);
		Page<DeveloperDTO> developerDtoPage = developerEntities.map(dv -> modelMapper.map(dv, DeveloperDTO.class));
		return developerDtoPage;
	}
	
	@Override
	public void deleteDeveloper(Integer devId) {		
		developerRepository.deleteById(devId);
	}
}



