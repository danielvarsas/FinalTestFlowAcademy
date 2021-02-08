package com.flowacademy.finaltest.service;

import com.flowacademy.finaltest.repository.TeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TeamService {

    private static final Logger log = LoggerFactory.getLogger(TeamService.class);
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }


}
