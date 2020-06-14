package com.wander.backend.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
@RequestMapping(value = "/api")
public class OtherEndpoint {

    @ResponseBody
    @GetMapping("/other")
    public ResponseEntity<String> doSomething() {
        log.error("localhost/other doSomething method. Authenticated User "
                + SecurityContextHolder.getContext().getAuthentication().getName());
        return ResponseEntity.ok("HI");
    }

    @ResponseBody
    @GetMapping("/adminonly")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<String> justForAdmin() {
        return ResponseEntity.ok("HI ADMIN.");
    }

    @ResponseBody
    @GetMapping("/useronly")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<String> justForUser() {
        return ResponseEntity.ok("HI USER");
    }
}
