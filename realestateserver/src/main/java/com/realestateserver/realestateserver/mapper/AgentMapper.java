package com.realestateserver.realestateserver.mapper;

import com.realestateserver.realestateserver.dto.AgentDto;
import com.realestateserver.realestateserver.entity.Agent;

public class AgentMapper {

    public static AgentDto mapToAgentDto(Agent agent){
        return new AgentDto(
            agent.getId(),
            agent.getName(), 
            agent.getSurname(),
            agent.getIdNum(),
            agent.getCellphoneNum(),
            agent.getEmail(),
            agent.getPassword()
        );
    }

    public static Agent mapToAgent(AgentDto agentDto){
        return new Agent(
             agentDto.getId(),
            agentDto.getName(), 
            agentDto.getSurname(),
            agentDto.getIdNum(),
            agentDto.getCellphoneNum(),
            agentDto.getEmail(),
            agentDto.getPassword()
        );
    }

}
