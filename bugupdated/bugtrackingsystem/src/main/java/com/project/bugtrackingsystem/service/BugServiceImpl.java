package com.project.bugtrackingsystem.service;

import com.project.bugtrackingsystem.dto.BugDTO;
import com.project.bugtrackingsystem.dto.TestEngineerDTO;
import com.project.bugtrackingsystem.entity.Bug;
import com.project.bugtrackingsystem.repository.BugRepository;
import com.project.bugtrackingsystem.util.BugStatus;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BugServiceImpl implements BugService {

    @Autowired
    private BugRepository bugRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BugDTO createBug(BugDTO bugDTO) {
        Bug bug = modelMapper.map(bugDTO, Bug.class);
        bug = bugRepository.save(bug);
        return modelMapper.map(bug, BugDTO.class);
    }

    @Override
    public BugDTO updateBug(BugDTO bugDTO) {
        Bug existingBugEntity = bugRepository.findById(bugDTO.getBugId()).orElse(null);
        if (existingBugEntity != null) {
            Bug updateEntity=modelMapper.map(bugDTO, Bug.class);
            updateEntity = bugRepository.save(updateEntity);
            return modelMapper.map(updateEntity, BugDTO.class);
        } else {
            return null; // Handle the case where the bug is not found
        }
    }

    @Override
    public BugDTO findBugById(Integer bugId) {
        Bug bugEntity = bugRepository.findById(bugId).orElse(null);

        if (bugEntity != null) {
            return modelMapper.map(bugEntity, BugDTO.class);
        } else {
            return null; // Handle the case where the bug is not found
        }
    }

    @Override
    public List<BugDTO> findAllBugs() {
        List<Bug> bugEntities = bugRepository.findAll();

        return bugEntities.stream()
                .map(bug -> modelMapper.map(bug, BugDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BugDTO> findAllBugsByProjectId(Integer projId) {
        List<Bug> bugEntities = bugRepository.findAllByProjectProjId(projId);

        return bugEntities.stream()
                .map(bug -> modelMapper.map(bug, BugDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BugDTO> findBugsByStatus(BugStatus status) {
        List<Bug> bugEntities = bugRepository.findAllByStatus(status);

        return bugEntities.stream()
                .map(bug -> modelMapper.map(bug, BugDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BugDTO> findBugsBySeverity(String severity) {
        List<Bug> bugEntities = bugRepository.findAllBySeverity(severity);

        return bugEntities.stream()
                .map(bug -> modelMapper.map(bug, BugDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BugDTO> findBugsByDate(LocalDate date) {
        List<Bug> bugEntities = bugRepository.findAllByStartDate(date);

        return bugEntities.stream()
                .map(bug -> modelMapper.map(bug, BugDTO.class))
                .collect(Collectors.toList());
    }

//    @Override
//    public List<BugDTO> findBugsCreatedByTestEngineer(TestEngineerDTO userId) {
//    	Integer userid=userId.getUserId();
//        List<Bug> bugEntities = bugRepository.findAllByCreatedByTestEngineerId(userid);
//
//        return bugEntities.stream()
//                .map(bug -> modelMapper.map(bug, BugDTO.class))
//                .collect(Collectors.toList());
//    }
//  @Override
//  public List<BugDTO> findBugsAssignedToDeveloper(Integer userId) {
//      List<Bug> bugEntities = bugRepository.findAllByAssignToDevId(userId);
//
//      return bugEntities.stream()
//              .map(bug -> modelMapper.map(bug, BugDTO.class))
//              .collect(Collectors.toList());
//  }

//    @Override
//    public List<BugDTO> findBugsByProjectIdAndDevId(Integer projId, Integer userId) {
//        List<Bug> bugEntities = bugRepository.findAllByProjectProjIdAndAssignToDevId(projId, userId);
//
//        return bugEntities.stream()
//                .map(bug -> modelMapper.map(bug, BugDTO.class))
//                .collect(Collectors.toList());
//    }

//    @Override
//    public List<BugDTO> findBugsByProjectIdAndTestEngId(Integer projId, Integer userId) {
//        List<Bug> bugEntities = bugRepository.findAllByProjectProjIdAndCreatedByTestEngineerId(projId, userId);
//
//        return bugEntities.stream()
//                .map(bug -> modelMapper.map(bug, BugDTO.class))
//                .collect(Collectors.toList());
//    }

//  @Override
//  public List<BugDTO> findBugsAssignedToDeveloperByStatus(Integer userId, String status) {
//      List<Bug> bugEntities = bugRepository.findAllByAssignToDevIdAndStatus(userId, status);
//
//      return bugEntities.stream()
//              .map(bug -> modelMapper.map(bug, BugDTO.class))
//              .collect(Collectors.toList());
//  }
//    @Override
//  public List<BugDTO> findBugsByDevIdAndDate(Integer userId, LocalDate startDate, LocalDate endDate) {
//      List<Bug> bugEntities = bugRepository.findAllByAssignToDevIdAndStartDateBetween(userId, startDate, endDate);
//
//      return bugEntities.stream()
//              .map(bug -> modelMapper.map(bug, BugDTO.class))
//              .collect(Collectors.toList());
//  }
}
