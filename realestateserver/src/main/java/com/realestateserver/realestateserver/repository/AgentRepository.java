package com.realestateserver.realestateserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.realestateserver.realestateserver.entity.Agent;


public interface AgentRepository extends JpaRepository<Agent, Long> {

    Agent findByCellphoneNum(String cellphoneNum);
}
