package com.app.gathertime.dto.userDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class RegistrationRequestDTO {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
}
