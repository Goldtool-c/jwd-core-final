package com.epam.jwd.core_final.service;

import com.epam.jwd.core_final.criteria.Criteria;
import com.epam.jwd.core_final.domain.CrewMember;

import java.util.List;
import java.util.Optional;

public interface CrewService {

    List<CrewMember> findAllCrewMembers();

    List<CrewMember> findAllCrewMembersByCriteria(Criteria<? extends CrewMember> criteria);

    Optional<CrewMember> findCrewMemberByCriteria(Criteria<? extends CrewMember> criteria);

    CrewMember updateCrewMemberDetails(CrewMember crewMember);

    void assignCrewMemberOnMission(CrewMember crewMember) throws RuntimeException;

    CrewMember createCrewMember(CrewMember spaceship) throws RuntimeException;
}