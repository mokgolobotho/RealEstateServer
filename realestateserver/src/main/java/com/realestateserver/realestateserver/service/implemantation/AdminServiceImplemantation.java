package com.realestateserver.realestateserver.service.implemantation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.realestateserver.realestateserver.dto.AdminDto;
import com.realestateserver.realestateserver.entity.Admin;
import com.realestateserver.realestateserver.exception.ResourceNotFoundException;
import com.realestateserver.realestateserver.mapper.AdminMapper;
import com.realestateserver.realestateserver.repository.AdminRepository;
import com.realestateserver.realestateserver.service.AdminService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AdminServiceImplemantation implements AdminService{

    private AdminRepository adminRepo;
    @Override
    public AdminDto createAdmin(AdminDto adminDto) {
        Admin admin = AdminMapper.mapToAdmin(adminDto);
        Admin saveAdAdmin = adminRepo.save(admin);
        return AdminMapper.mapToAdminDto(saveAdAdmin);
    }
    @Override
    public AdminDto getAdminById(Long adminId) {
        Admin admin = adminRepo.findById(adminId)
            .orElseThrow(() -> new ResourceNotFoundException("Admin not found with id: " + adminId));
        return AdminMapper.mapToAdminDto(admin);
       }
    @Override
    public List<AdminDto> getAllAdmins() {
        List<Admin> admins = adminRepo.findAll();
        return admins.stream().map((Admin) -> AdminMapper.mapToAdminDto(Admin))
            .collect(Collectors.toList());
    }
    @Override
    public AdminDto updateAdmin(Long AdminId, AdminDto updateAdmin) {
    Admin admin = adminRepo.findById(AdminId).
        orElseThrow(() -> new ResourceNotFoundException("Admin not found with id: " + AdminId));
        admin.setName(updateAdmin.getName());
        admin.setSurname(updateAdmin.getSurname());
        admin.setIdNum(updateAdmin.getIdNum());
        admin.setCellphoneNum(updateAdmin.getCellphoneNum());
        admin.setEmail(updateAdmin.getEmail());

        Admin updatedAdminObj = adminRepo.save(admin);
        return AdminMapper.mapToAdminDto(updatedAdminObj);
    }
    @Override
    public void deleteAdmin(Long adminId) {
        Admin admin = adminRepo.findById(adminId).
        orElseThrow(() -> new ResourceNotFoundException("Admin not found with id: " + adminId));
       adminRepo.deleteById(adminId);
        }


}
