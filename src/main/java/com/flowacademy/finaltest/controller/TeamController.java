package com.flowacademy.finaltest.controller;

import com.flowacademy.finaltest.entity.Team;
import com.flowacademy.finaltest.service.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.xml.bind.ValidationException;
import java.util.List;
import java.util.Optional;

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
    public Team createNewTeam(@RequestBody Team team) throws ValidationException {
        log.info("Received request for creating a new team {} ... ", team);


            Team newTeam = teamService.createNewTeam(team); // method to make
            log.debug("The new team is created, with name: {}", newTeam);
            return newTeam;
    }

    @PutMapping("/{id}")
    public Team updateTeam(@RequestBody Team team, @PathVariable ("id")  String id) throws ValidationException {
        log.info("Received update team request {} ... ", team);
            Team updatedTeam = teamService.updateTeam(team, id);
            log.debug("The new team is: {}", updatedTeam);
            return updatedTeam;

    }

    @GetMapping
    public List<Team> getTeam(@RequestParam(value = "page", required = false) Optional<Integer> page,
                          @RequestParam(value = "limit", required = false) Optional<Integer> limit) {
        log.info("Retrieving teams (page: {}, limit: {}) ...", page.isPresent() ? page.get() : "n.a.", limit.orElse(10));
        List<Team> teamlist;
        if (page.isPresent()) {
            teamlist = teamService.listTeams(
                    PageRequest.of(page.get(), limit.orElse(10)));
        } else {
            teamlist = teamService.listTeams();
        }
        log.debug("Teams: {}", teamlist.size());
        return teamlist;
    }



}
