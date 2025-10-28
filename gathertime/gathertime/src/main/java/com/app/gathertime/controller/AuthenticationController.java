package com.app.gathertime.controller;

import com.app.gathertime.dto.userDTOs.AuthenticationResponseDTO;
import com.app.gathertime.dto.userDTOs.LoginRequestDTO;
import com.app.gathertime.dto.userDTOs.RegistrationRequestDTO;
import com.app.gathertime.dto.userDTOs.UserResponseDTO;
import com.app.gathertime.mapper.UserMapper;
import com.app.gathertime.repository.UserRepository;
import com.app.gathertime.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final UserRepository userRepository;

    @PostMapping("/registration")
    public ResponseEntity<UserResponseDTO> createUser(
            @RequestBody RegistrationRequestDTO registrationRequestDTO
    ){
        return ResponseEntity.ok(authenticationService.register(registrationRequestDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponseDTO> login(
            @RequestBody LoginRequestDTO request
    ){
        return ResponseEntity.ok(authenticationService.login(request));
    }

    @GetMapping("/check-email/{email}")
    public ResponseEntity<UserResponseDTO> checkEmail(@PathVariable("email") String email){
        return ResponseEntity.ok(UserMapper.toDto(userRepository.findByEmail(email).orElseThrow()));
    }
}
