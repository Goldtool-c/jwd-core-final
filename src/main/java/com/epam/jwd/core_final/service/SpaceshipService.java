package com.epam.jwd.core_final.service;

import com.epam.jwd.core_final.criteria.Criteria;
import com.epam.jwd.core_final.domain.Spaceship;

import java.util.List;
import java.util.Optional;

public interface SpaceshipService {

    List<Spaceship> findAllSpaceships();

    List<Spaceship> findAllSpaceshipsByCriteria(Criteria<? extends Spaceship> criteria);

    Optional<Spaceship> findSpaceshipByCriteria(Criteria<? extends Spaceship> criteria);

    Spaceship updateSpaceshipDetails(Spaceship spaceship);

    void assignSpaceshipOnMission(Spaceship crewMember) throws RuntimeException;

    Spaceship createSpaceship(Spaceship spaceship) throws RuntimeException;
}
