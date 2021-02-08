package com.flowacademy.finaltest.service;

import com.flowacademy.finaltest.entity.Team;
import com.flowacademy.finaltest.repository.TeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.ValidationException;

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


}
