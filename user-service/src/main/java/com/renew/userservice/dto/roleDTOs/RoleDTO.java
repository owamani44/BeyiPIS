package com.renew.userservice.dto.roleDTOs;

import java.util.List;
import java.util.UUID;

public class RoleDTO {
    private String userID;
    private List<String> roleID;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public List<String> getRoleID() {
        return roleID;
    }

    public void setRoleID(List<String> roleID) {
        this.roleID = roleID;
    }
}
