package com.flowacademy.finaltest.repository;

import com.flowacademy.finaltest.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


    @Repository
    public interface TeamRepository extends JpaRepository<Team, String> {
    }


