package com.realestateserver.realestateserver.mapper;

import com.realestateserver.realestateserver.dto.AgentDto;
import com.realestateserver.realestateserver.entity.Agent;

public class AgentMapper {

    public static AgentDto mapToAgentDto(Agent agent){
        return new AgentDto(
            agent.getCellphoneNum(),
            agent.getName(), 
            agent.getSurname(),
            agent.getIdNum(),
            agent.getEmail()
        );
    }

    public static Agent mapToAgent(AgentDto agentDto){
        return new Agent(
            agentDto.getCellphoneNum(), 
            agentDto.getName(), 
            agentDto.getSurname(),
            agentDto.getIdNum(),
            agentDto.getEmail()
        );
    }

}