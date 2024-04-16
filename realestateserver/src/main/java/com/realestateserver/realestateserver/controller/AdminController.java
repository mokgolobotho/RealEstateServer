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
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import com.realestateserver.realestateserver.dto.AdminDto;
import com.realestateserver.realestateserver.service.AdminService;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/admins")
public class AdminController {

    private AdminService adminService;

    //Add Admins REST api
    @PostMapping
    public ResponseEntity<AdminDto> createAdmin(@RequestBody AdminDto adminDto){
        AdminDto savedDto = adminService.createAdmin(adminDto);
        return new ResponseEntity<>(savedDto, HttpStatus.CREATED);
        
    }

    //Get Admins REST api
    @GetMapping("{id}")
    public ResponseEntity<AdminDto> getAdminById(@PathVariable("id") Long adminId){
        AdminDto adminDto = adminService.getAdminById(adminId);
        return ResponseEntity.ok(adminDto);
    }

    //get all Admins Rest api
    @GetMapping
    public ResponseEntity<List<AdminDto>> getAllAdmins(){
        List<AdminDto> admins = adminService.getAllAdmins();
        return ResponseEntity.ok(admins);
    }

    //Update employee Rest api
    @PutMapping("{id}")
    public ResponseEntity<AdminDto> updateAdmin(@PathVariable("id") Long adminId,@RequestBody  AdminDto updatedAdmin){
        AdminDto adminDto = adminService.updateAdmin(adminId, updatedAdmin);
        return ResponseEntity.ok(adminDto);
    }

    //delete Admin Rest API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable ("id") Long adminId){
        adminService.deleteAdmin(adminId);
        return ResponseEntity.ok("Admin deleted successfully");
    }
}
