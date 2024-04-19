package com.realestateserver.realestateserver.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.realestateserver.realestateserver.dto.AgentDto;
import com.realestateserver.realestateserver.service.AgentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;

@CrossOrigin("*")
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
    /*@GetMapping("{id}")
    public ResponseEntity<AgentDto> getAgentById(@PathVariable("id") Long agentId){
        AgentDto agentDto = agentService.getAgentById(agentId);
        return ResponseEntity.ok(agentDto);
    }*/

    @GetMapping("{cellphoneNum}")
public ResponseEntity<AgentDto> getAgentByCellphoneNum(@PathVariable("cellphoneNum") String cellphoneNum){
    AgentDto agentDto = agentService.getAgentByCellphoneNum(cellphoneNum);
    if(agentDto != null) {
        return ResponseEntity.ok(agentDto);
    } else {
        return ResponseEntity.notFound().build();
    }
}
    //get all agents Rest api
    @GetMapping
    public ResponseEntity<List<AgentDto>> getAllAgents(){
        List<AgentDto> agents = agentService.getAllAgents();
        return ResponseEntity.ok(agents);
    }

    //Update property Rest api
    @PutMapping("{id}")
    public ResponseEntity<AgentDto> updateAgent(@PathVariable("id") Long agentId,@RequestBody  AgentDto updatedAgent){
        AgentDto agentDto = agentService.updateAgent(agentId, updatedAgent);
        return ResponseEntity.ok(agentDto);
    }

    //delete Agent Rest API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAgent(@PathVariable ("id") Long agentId){
        agentService.deleteAgent(agentId);
        return ResponseEntity.ok("Agent deleted successfully");
    }
}
