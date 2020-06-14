package com.wander.backend.security.jwt;

/**
 * @author Rohit Roy
 */
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponse {

    private String token;

}
