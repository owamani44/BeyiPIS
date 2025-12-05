package com.renew.userservice.controller;


import com.renew.userservice.dto.userDTOs.UserRequestDTO;
import com.renew.userservice.dto.userDTOs.UserResponseDTO;
import com.renew.userservice.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@Tag(name = "Users",description ="API for managing users")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @Operation(summary = "Get users")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers() {
        List<UserResponseDTO> users = userService.getUsers();
        return ResponseEntity.ok().body(users);
    }

    @PostMapping
    @Operation(summary = "Create users")
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
    @Operation(summary = "update users")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable UUID userid,
                                                      @Validated({Default.class})
                                                          @RequestBody UserRequestDTO userRequestDTO){
        UserResponseDTO userResponseDTO = userService.updateUser(userid, userRequestDTO);
        return ResponseEntity.ok().body(userResponseDTO);
    }

    @DeleteMapping("/{userid}")
    @Operation(summary = "Delete users")
    public ResponseEntity<UserResponseDTO> deleteUser(@PathVariable UUID userid){
        userService.deleteUser(userid);
        return ResponseEntity.noContent().build();
    }
    }
