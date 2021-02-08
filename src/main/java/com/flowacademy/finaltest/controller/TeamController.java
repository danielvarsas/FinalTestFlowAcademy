package com.flowacademy.finaltest.controller;

import com.flowacademy.finaltest.entity.Team;
import com.flowacademy.finaltest.service.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.xml.bind.ValidationException;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

    private TeamService teamService;

    private static final Logger log = LoggerFactory.getLogger(TeamController.class);

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Team createNewTeam(@RequestBody Team team) {
        log.info("Received request for creating a new team {} ... ", team);

        try {
            Team newTeam = teamService.createNewTeam(team); // method to make
            log.debug("The new team is created, with name: {}", newTeam);
            return newTeam;
        } catch (ValidationException e) {
            log.error("Error accured while creating new team: " + e.getMessage());
            throw new ResponseStatusException(e.getHttpStatus(), e.getMessage());
        }



    }

}
