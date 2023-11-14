package com.project.bugtrackingsystem.service;

import com.project.bugtrackingsystem.dto.DeveloperDTO;
import com.project.bugtrackingsystem.dto.ProjectDTO;
import com.project.bugtrackingsystem.entity.Developer;
import com.project.bugtrackingsystem.entity.Project;
import com.project.bugtrackingsystem.repository.DeveloperRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeveloperServiceImpl implements DeveloperService {
	
	@Autowired
	private DeveloperRepository developerRepository;
	
//	@Autowired
//	private ProjectRepository projectRepository;
	
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
	public DeveloperDTO updateDeveloper(DeveloperDTO developerDTO) {
		// Retrieve the existing developer entity from the database
		Developer existingDeveloperEntity = modelMapper.map(developerDTO, Developer.class);
		existingDeveloperEntity= developerRepository.findById(existingDeveloperEntity.getUserId()).orElse(null);

		if (existingDeveloperEntity != null) {
			existingDeveloperEntity.setDevName(existingDeveloperEntity.getDevName());
			existingDeveloperEntity.setUserEmail(existingDeveloperEntity.getUserEmail());

			existingDeveloperEntity = developerRepository.save(existingDeveloperEntity);

			// Map the updated entity to a DTO and return it
			return modelMapper.map(existingDeveloperEntity, DeveloperDTO.class);
		} else {
			// Handle the case where the developer is not found
			return null;
		}
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
	public List<DeveloperDTO> getAllDevelopers() {
//		Developer developerEntity = modelMapper.map(devId, Developer.class);
		List<Developer> developerEntities = developerRepository.findAll();
		
		return developerEntities.stream()
                .map(dev -> modelMapper.map(dev, DeveloperDTO.class))
                .collect(Collectors.toList());
	}

	@Override
	public List<ProjectDTO> getProjectsByDevId(Integer devId) {
		// Retrieve the developer entity from the database
		Developer developerEntity = modelMapper.map(devId, Developer.class);
		developerEntity = developerRepository.findById(devId).orElse(null);
		
		List<Project> list=developerEntity.getProjects();
		List<ProjectDTO> list1=list.stream()
		.map(p-> modelMapper.map(p, ProjectDTO.class))
		.collect(Collectors.toList());
			return list1;
		}
	}



