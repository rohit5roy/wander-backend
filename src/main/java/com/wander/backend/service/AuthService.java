package com.wander.backend.service;

/**
 * @author Rohit Roy
 */
import com.wander.backend.model.User;
import com.wander.backend.repository.UserRepository;
import com.wander.backend.security.jwt.JwtResponse;
import com.wander.backend.security.jwt.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthService implements UserDetailsService {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public JwtResponse login(String userName, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
        return new JwtResponse(jwtUtils.generateToken(loadUserByUsername(userName).getUsername()));
    }

    public JwtResponse register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        log.error("User role::::::::::::::: " + user.getRoles().get(0));
        return new JwtResponse(jwtUtils.generateToken(loadUserByUsername(user.getUsername()).getUsername()));
    }

    @Override
    public User loadUserByUsername(String userName) throws UsernameNotFoundException {
        log.error("Retrieving User with userName: " + userName);
        return userRepository.findByUserNameIgnoreCaseAndEnabledTrue(userName)
                .orElseThrow(() -> new UsernameNotFoundException("USERNAME NOT FOUND"));
    }

}
