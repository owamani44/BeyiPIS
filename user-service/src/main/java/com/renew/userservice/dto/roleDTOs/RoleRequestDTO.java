package com.renew.userservice.dto.roleDTOs;

import jakarta.validation.constraints.NotBlank;

public class RoleRequestDTO {
    @NotBlank
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
