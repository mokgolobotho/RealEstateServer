package com.realestateserver.realestateserver.mapper;

import com.realestateserver.realestateserver.dto.AdminDto;
import com.realestateserver.realestateserver.entity.Admin;

public class AdminMapper {

    public static AdminDto mapToAdminDto(Admin admin){
        return new AdminDto(
            admin.getAdminId(), 
            admin.getName(), 
            admin.getSurname(),
            admin.getIdNum(),
            admin.getCellphoneNum(),
            admin.getEmail()
        );
    }

    public static Admin mapToAdmin(AdminDto adminDto){
        return new Admin(
            adminDto.getAdminId(), 
            adminDto.getName(), 
            adminDto.getSurname(),
            adminDto.getIdNum(),
            adminDto.getCellphoneNum(),
            adminDto.getEmail()
        );
    }
}
