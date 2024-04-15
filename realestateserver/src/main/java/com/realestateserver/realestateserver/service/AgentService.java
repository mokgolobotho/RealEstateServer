package com.realestateserver.realestateserver.service;

import java.util.List;

import com.realestateserver.realestateserver.dto.AgentDto;

public interface AgentService {
    AgentDto createAgent(AgentDto agentDto);

    AgentDto getAgentById(Long agentId);

    List<AgentDto> getAllAgents();
}
