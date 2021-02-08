package com.flowacademy.finaltest.service;

import com.flowacademy.finaltest.entity.Team;
import com.flowacademy.finaltest.repository.TeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.xml.bind.ValidationException;
import java.util.List;

public class TeamService {

    private static final Logger log = LoggerFactory.getLogger(TeamService.class);
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Team createNewTeam(Team team) throws ValidationException {
        log.info("Creating new team with incoming data: {} ... ", team);

        Team newTeam = teamRepository.save(team);
        log.debug("Created team is: {}", team);
        return newTeam;
    }

    public Team updateTeam(Team team, String id) throws ValidationException {
        log.info("Updating team with data: {} ... ", team);

        Team updatedTeam = teamRepository.save(team);
        log.debug("Team updated: {}", team);
        return updatedTeam;
    }

    public List<Team> listTeams(Pageable pageable) {
        log.info("Listing teams (page information: {}) ...", pageable);
        Page<Team> foodPage = teamRepository.findAll(pageable);
        List<Team> foodList = foodPage.getContent();
        log.debug("Total count: {}, total pages: {}", foodPage.getTotalElements(), foodPage.getTotalPages());
        return foodList;
    }

    public List<Team> listTeams() {
        log.info("Listing all foods ...");
        List<Team> foodList = teamRepository.findAll();
        log.debug("Total count: {}, ", foodList.size());
        return foodList;
    }


}
