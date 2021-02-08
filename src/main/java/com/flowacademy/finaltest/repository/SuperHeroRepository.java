package com.flowacademy.finaltest.repository;

import com.flowacademy.finaltest.entity.SuperHero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SuperHeroRepository extends JpaRepository<SuperHero, String> {
}

