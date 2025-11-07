package com.renew.userservice.controller;

import com.backend.BeyiAPI.dto.roleDTOs.RoleDTO;
import com.backend.BeyiAPI.dto.userDTOs.UserRequestDTO;
import com.backend.BeyiAPI.dto.userDTOs.UserResponseDTO;
import com.backend.BeyiAPI.model.User;
//import com.backend.BeyiAPI.service.RoleAssignmentService;
import com.backend.BeyiAPI.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<UserResponseDTO> users = userService.getUsers();
        return ResponseEntity.ok().body(users);
    }

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@Valid @RequestBody UserRequestDTO userRequestDTO){
        UserResponseDTO userResponseDTO = userService.createUser(userRequestDTO);
        return ResponseEntity.ok().body(userResponseDTO);
    }

//    @PostMapping("/assign-role")
//    public ResponseEntity<User> assignRole(@RequestBody RoleDTO roleDTO, User user) {
//        User roleUser = roleAssignmentService.assignRoles(roleDTO, user);
//        return ResponseEntity.ok(roleUser);
//    }

    @PutMapping("/{userid}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable UUID userid,
                                                      @Validated({Default.class})
                                                          @RequestBody UserRequestDTO userRequestDTO){
        UserResponseDTO userResponseDTO = userService.updateUser(userid, userRequestDTO);
        return ResponseEntity.ok().body(userResponseDTO);
    }

    @DeleteMapping("/{userid}")
    public ResponseEntity<UserResponseDTO> deleteUser(@PathVariable UUID userid){
        userService.deleteUser(userid);
        return ResponseEntity.noContent().build();
    }
    }
