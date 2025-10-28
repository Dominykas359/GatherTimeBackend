package com.app.gathertime.mapper;

import com.app.gathertime.dto.userDTOs.RegistrationRequestDTO;
import com.app.gathertime.dto.userDTOs.UserResponseDTO;
import com.app.gathertime.model.User;

public class UserMapper {

    public static UserResponseDTO toDto(User user){

        return UserResponseDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }

    public static User fromDto(RegistrationRequestDTO registrationRequestDTO){

        return User.builder()
                .email(registrationRequestDTO.getEmail())
                .password(registrationRequestDTO.getPassword())
                .firstName(registrationRequestDTO.getFirstName())
                .lastName(registrationRequestDTO.getLastName())
                .build();
    }
}
