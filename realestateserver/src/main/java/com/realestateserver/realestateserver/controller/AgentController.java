package com.realestateserver.realestateserver.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.realestateserver.realestateserver.dto.AgentDto;
import com.realestateserver.realestateserver.service.AgentService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/agents")
public class AgentController {

    private AgentService agentService;

    //Add agents REST api
    @PostMapping
    public ResponseEntity<AgentDto> createAgent(@RequestBody AgentDto agentDto){
        AgentDto savedDto = agentService.createAgent(agentDto);
        return new ResponseEntity<>(savedDto, HttpStatus.CREATED);
        
    }

    //Get agents REST api
    @GetMapping("{id}")
    public ResponseEntity<AgentDto> getAgentById(@PathVariable("id") Long agentId){
        AgentDto agentDto = agentService.getAgentById(agentId);
        return ResponseEntity.ok(agentDto);
    }

    //get all agents Rest api
    @GetMapping
    public ResponseEntity<List<AgentDto>> getAllAgents(){
        List<AgentDto> agents = agentService.getAllAgents();
        return ResponseEntity.ok(agents);
    }
}
