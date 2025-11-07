package com.renew.userservice.service;


import com.renew.userservice.dto.userDTOs.UserRequestDTO;
import com.renew.userservice.dto.userDTOs.UserResponseDTO;
import com.renew.userservice.exception.EmailAlreadyExists;
import com.renew.userservice.exception.UserNotFoundException;
import com.renew.userservice.mapper.UserMapper;
import com.renew.userservice.model.User;
import com.renew.userservice.repo.UserRepo;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    public UserRepo userRepo;
    public static UserMapper userMapper;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    public String generateUsername(String firstName, String lastName) {
        String base = (firstName.substring(0, 1) + lastName).toLowerCase();

        String username = base;
        int counter = 1;
        while (userRepo.existsByUsername(username)) {
            username = base + counter;
            counter++;
        }
        return username;
    }


    public List<UserResponseDTO> getUsers() {
        List<User> users = userRepo.findAll();
        return users.stream().map(UserMapper::toDTO).toList();
    }

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        if (userRepo.existsByEmail(userRequestDTO.getEmail()))
            throw new EmailAlreadyExists("A user with this email already exists "
                    + userRequestDTO.getEmail());

        User newUser = UserMapper.toModel(userRequestDTO);

        String username = generateUsername(newUser.getFirstName(),
                newUser.getLastName());
        newUser.setUsername(username);

        User savedUser = userRepo.save(newUser);

        return UserMapper.toDTO(newUser);
    }



    public UserResponseDTO updateUser(UUID userid, UserRequestDTO userRequestDTO) {
        User user = userRepo.findById(userid).orElseThrow(
                () -> new UserNotFoundException("User not found with ID :" + userid
        ));
        if(userRepo.existsByEmailAndUseridIsNot(userRequestDTO.getEmail() , userid))
            throw new EmailAlreadyExists("A user with this email already exists " + userRequestDTO.getEmail());
        user.setFirstName(userRequestDTO.getFirstName());
        user.setLastName(userRequestDTO.getLastName());
        user.setTel(userRequestDTO.getTel());
        user.setEmail(userRequestDTO.getEmail());
        user.setDistrict(userRequestDTO.getDistrict());


        User updatedUser = userRepo.save(user);
        return UserMapper.toDTO(updatedUser);
    }

    public void deleteUser(UUID userid) {
        userRepo.deleteById(userid);
    }
}
