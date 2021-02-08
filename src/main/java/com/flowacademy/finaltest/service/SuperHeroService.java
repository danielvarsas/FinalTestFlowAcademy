package com.flowacademy.finaltest.service;

import com.flowacademy.finaltest.repository.SuperHeroRepository;
import com.flowacademy.finaltest.repository.TeamRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SuperHeroService {

    private static final Logger log = LoggerFactory.getLogger(SuperHeroService.class);
    private final SuperHeroRepository superHeroRepository;

    public SuperHeroService(SuperHeroRepository superHeroRepository) {
        this.superHeroRepository = superHeroRepository;
    }


}
