package com.renew.userservice.service;


import com.renew.userservice.dto.roleDTOs.RoleRequestDTO;
import com.renew.userservice.dto.roleDTOs.RoleResponseDTO;
import com.renew.userservice.mapper.RoleMapper;
import com.renew.userservice.model.Role;
import com.renew.userservice.repo.RoleRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoleService {

    private final RoleRepo roleRepo;

    public RoleService(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    public List<RoleResponseDTO> getRoles() {
        List<Role> role = roleRepo.findAll();
        return role.stream().map(RoleMapper::toDTO).toList();
    }

    public RoleResponseDTO createRole(RoleRequestDTO roleRequestDTO) {
        Role newRole = roleRepo.save(RoleMapper.toRoleModel(roleRequestDTO));
        return RoleMapper.toDTO(newRole);
    }

    public void deleteRole(UUID roleId) {
        roleRepo.deleteById(roleId);
    }


}
