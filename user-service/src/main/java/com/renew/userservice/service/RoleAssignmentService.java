//package com.backend.BeyiAPI.service;
//
//import com.backend.BeyiAPI.dto.roleDTOs.RoleDTO;
//import com.backend.BeyiAPI.dto.userDTOs.UserResponseDTO;
//import com.backend.BeyiAPI.exception.UserNotFoundException;
//import com.backend.BeyiAPI.model.Role;
//import com.backend.BeyiAPI.model.User;
//import com.backend.BeyiAPI.repo.RoleRepo;
//import com.backend.BeyiAPI.repo.UserRepo;
//import jakarta.transaction.Transactional;
//import org.springframework.stereotype.Service;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Service
//public class RoleAssignmentService {
//    private final RoleRepo roleRepo;
//    private final UserRepo userRepo;
//
//    public RoleAssignmentService(RoleRepo roleRepo, UserRepo userRepo) {
//        this.roleRepo = roleRepo;
//        this.userRepo = userRepo;
//    }
//
//    @Transactional
//    public User assignRoles(RoleDTO roleDTO, ) {
//        User user = userRepo.findById(userResponseDTO.getUserID()).
//                orElseThrow(()->new RuntimeException("User not found"));
//    }
//
//}
