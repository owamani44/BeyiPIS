package com.renew.userservice.dto.userDTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserRequestDTO {

    @NotBlank
    @Size(min = 1, max = 100, message = "First Name should be included")
    private String firstName;

    @NotBlank
    @Size(min = 1, max = 100, message = "Last Name should be included")
    private String lastName;

    @NotBlank
    @Email(message = "Email should be valid")
    private String email;


    @NotBlank
    @Size(max = 13, message = "Telephone number should be included")
    private String tel;

    @NotBlank
    @Size(message = "District name should be included")
    private String district;

    private String username;

    private LocalDateTime userCreatedAt = LocalDateTime.now();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getUserCreatedAt() {
        return userCreatedAt;
    }

    public void setUserCreatedAt(LocalDateTime userCreatedAt) {
        this.userCreatedAt = userCreatedAt;
    }
}
