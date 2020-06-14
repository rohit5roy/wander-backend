package com.wander.backend.security.jwt;

/**
 * @author Rohit Roy
 */
import com.wander.backend.model.User;
import com.wander.backend.model.UserAuthentication;
import com.wander.backend.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

@Component
@Slf4j
public class JwtTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AuthService authService;

    private final String tokenPattern = "^[A-Za-z0-9-_=]+\\.[A-Za-z0-9-_=]+\\.?[A-Za-z0-9-_.+/=]*$";

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {
        log.error("Checking token in Header");
        String token = httpServletRequest.getHeader("token");
        if (hasToken(token)) {

            log.error("There is a token in Header");

            User user = authService.loadUserByUsername(jwtUtils.getUserNameFromToken(token));

            log.error("User loaded. Setting Context UserAuthentication");
            SecurityContextHolder.getContext().setAuthentication(
                    new UserAuthentication(user.getUsername(), "", user.getAuthorities(), user.getUserBasicInfo()));

            log.error("Authenticated user: " + SecurityContextHolder.getContext().getAuthentication().getName()
                    + " with authorities " + user.getAuthorities());
        } else {
            log.warn("There is no token in header or it does not match required pattern.");
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }

    private boolean hasToken(String token) {
        return StringUtils.hasText(token) && Pattern.matches(tokenPattern, token);
    }
}
