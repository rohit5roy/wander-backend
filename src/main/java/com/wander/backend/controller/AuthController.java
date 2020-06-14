package com.wander.backend.controller;

/**
 * @author Rohit Roy
 */
import com.wander.backend.model.dto.request.LoginRequestDTO;
import com.wander.backend.model.dto.request.RegisterDTO;
import com.wander.backend.model.mapper.AuthMapper;
import com.wander.backend.security.jwt.JwtResponse;
import com.wander.backend.service.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Controller
@Tag(name = "Authentication APIs", description = "The APIs for login and registration.")
@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private AuthMapper authMapper;

    @PostMapping("/login")
    public JwtResponse login(@RequestBody @Valid LoginRequestDTO loginRequestDTO) {
        return authService.login(loginRequestDTO.getUserName().toLowerCase(), loginRequestDTO.getPassword());
    }

    @PostMapping("/register")
    public JwtResponse register(@RequestBody @Valid RegisterDTO registerDTO) {
        return authService.register(authMapper.mapToUser(registerDTO));
    }

}
