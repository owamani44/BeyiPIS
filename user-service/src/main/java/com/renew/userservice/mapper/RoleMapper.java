package com.renew.userservice.mapper;


import com.renew.userservice.dto.roleDTOs.RoleRequestDTO;
import com.renew.userservice.dto.roleDTOs.RoleResponseDTO;
import com.renew.userservice.model.Role;

public class RoleMapper {

    public static RoleResponseDTO toDTO(Role role) {
        RoleResponseDTO dto = new RoleResponseDTO();
        dto.setRoleID(role.getRoleID().toString());
        dto.setRoleName(role.getRoleName());

        return dto;
    }

    public static Role toRoleModel(RoleRequestDTO roleRequestDTO) {
        Role role = new Role();
        role.setRoleName(roleRequestDTO.getRoleName());

        return role;
    }
}
