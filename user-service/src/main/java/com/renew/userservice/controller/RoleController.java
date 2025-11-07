package com.renew.userservice.controller;


import com.renew.userservice.dto.roleDTOs.RoleRequestDTO;
import com.renew.userservice.dto.roleDTOs.RoleResponseDTO;
import com.renew.userservice.service.RoleService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<List<RoleResponseDTO>> getAllRoles() {
        List<RoleResponseDTO> roles = roleService.getRoles();
        return ResponseEntity.ok().body(roles);
    }

    @PostMapping
    public ResponseEntity<RoleResponseDTO> createRole(@Valid @RequestBody RoleRequestDTO roleRequestDTO) {
        RoleResponseDTO roleResponseDTO = roleService.createRole(roleRequestDTO);
        return ResponseEntity.ok().body(roleResponseDTO);
    }

    @DeleteMapping
    public ResponseEntity<RoleResponseDTO> deleteRole(@PathVariable UUID roleId) {
        roleService.deleteRole(roleId);
        return ResponseEntity.noContent().build();
    }

}
