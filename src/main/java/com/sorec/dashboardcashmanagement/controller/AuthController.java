package com.sorec.dashboardcashmanagement.controller;

import com.sorec.dashboardcashmanagement.dto.LoginResponse;
import com.sorec.dashboardcashmanagement.dto.UserDTO;
import com.sorec.dashboardcashmanagement.security.JwtTokenProvider;
import com.sorec.dashboardcashmanagement.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthController(AuthenticationManager authenticationManager, UserService userService, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody UserDTO userDTO) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userDTO.getUsername(), userDTO.getPassword())
            );
            UserDTO user = userService.findByUsername(userDTO.getUsername());
            String token = jwtTokenProvider.createToken(userDTO.getUsername(), user.getRole());

            LoginResponse response = new LoginResponse(token, user);
            return ResponseEntity.ok(response);

        } catch (AuthenticationException e) {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }
}

