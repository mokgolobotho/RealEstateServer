package com.realestateserver.realestateserver.service;

import java.util.List;

import com.realestateserver.realestateserver.dto.AdminDto;

public interface AdminService {
    AdminDto createAdmin(AdminDto adminDto);

    AdminDto getAdminById(Long adminId);

    List<AdminDto> getAllAdmins();

    AdminDto updateAdmin(Long adminId, AdminDto updateAdmin);

    void deleteAdmin(Long adminId);
}
