package com.renew.userservice.mapper;


import com.renew.userservice.dto.userDTOs.UserRequestDTO;
import com.renew.userservice.dto.userDTOs.UserResponseDTO;
import com.renew.userservice.model.User;

public class UserMapper {


    public static UserResponseDTO toDTO(User user){
    UserResponseDTO userDTO = new UserResponseDTO();
    userDTO.setUserID(user.getUserid().toString());
    userDTO.setFirstName(user.getFirstName());
    userDTO.setLastName(user.getLastName());
    userDTO.setTel(user.getTel());
    userDTO.setEmail(user.getEmail());
    userDTO.setDistrict(user.getDistrict());
        userDTO.setUsername(user.getUsername());




    return userDTO;
}
public static User toModel(UserRequestDTO userRequestDTO){
    User user = new User();
    user.setFirstName(userRequestDTO.getFirstName());
    user.setLastName(userRequestDTO.getLastName());
    user.setTel(userRequestDTO.getTel());
    user.setEmail(userRequestDTO.getEmail());
    user.setDistrict(userRequestDTO.getDistrict());


    return user;
}
}
