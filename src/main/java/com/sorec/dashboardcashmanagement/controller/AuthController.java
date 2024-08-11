package com.sorec.dashboardcashmanagement.controller;

import com.sorec.dashboardcashmanagement.dto.LoginResponse;
import com.sorec.dashboardcashmanagement.dto.UserDTO;
import com.sorec.dashboardcashmanagement.security.JwtTokenProvider;
import com.sorec.dashboardcashmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO userDTO) {
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
