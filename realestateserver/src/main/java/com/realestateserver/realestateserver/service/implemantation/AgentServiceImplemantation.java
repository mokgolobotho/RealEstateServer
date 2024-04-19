package com.realestateserver.realestateserver.service.implemantation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.realestateserver.realestateserver.dto.AgentDto;
import com.realestateserver.realestateserver.entity.Agent;
import com.realestateserver.realestateserver.exception.ResourceNotFoundException;
import com.realestateserver.realestateserver.repository.AgentRepository;
import com.realestateserver.realestateserver.service.AgentService;
import com.realestateserver.realestateserver.mapper.AgentMapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AgentServiceImplemantation implements AgentService {

    private AgentRepository agentRepo;
    @Override
    public AgentDto createAgent(AgentDto agentDto) {
        Agent agent = AgentMapper.mapToAgent(agentDto);
        Agent saveAdagent = agentRepo.save(agent);
        return AgentMapper.mapToAgentDto(saveAdagent);
    }
    @Override
    public AgentDto getAgentById(Long agentId) {
        Agent agent = agentRepo.findById(agentId)
            .orElseThrow(() -> new ResourceNotFoundException("Agent not found with id: " + agentId));
        return AgentMapper.mapToAgentDto(agent);
       }

       public AgentDto getAgentByCellphoneNum(String cellphoneNum) {
        Agent agentOptional = agentRepo.findByCellphoneNum(cellphoneNum);
        return AgentMapper.mapToAgentDto(agentOptional);
    }
    @Override
    public List<AgentDto> getAllAgents() {
        List<Agent> agents = agentRepo.findAll();
        return agents.stream().map((agent) -> AgentMapper.mapToAgentDto(agent))
            .collect(Collectors.toList());
    }
    @Override
    public AgentDto updateAgent(Long agentId, AgentDto updateAgent) {
    Agent agent = agentRepo.findById(agentId).
        orElseThrow(() -> new ResourceNotFoundException("Agent not found with id: " + agentId));
        agent.setCellphoneNum(updateAgent.getCellphoneNum());
        agent.setName(updateAgent.getName());
        agent.setSurname(updateAgent.getSurname());
        agent.setEmail(updateAgent.getEmail());
        agent.setPassword(updateAgent.getPassword());

        Agent updatedAgentObj = agentRepo.save(agent);
        return AgentMapper.mapToAgentDto(updatedAgentObj);
    }
    @Override
    public void deleteAgent(Long agentId) {
        Agent agent = agentRepo.findById(agentId).
        orElseThrow(() -> new ResourceNotFoundException("Agent not found with id: " + agentId));
       agentRepo.deleteById(agentId);
        }

}

