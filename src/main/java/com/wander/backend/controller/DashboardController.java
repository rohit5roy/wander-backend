package com.wander.backend.controller;

/**
 * @author Rohit Roy
 */
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Tag(name = "Dashboard APIs", description = "The Dashboard APIs for catering Angular.")
public class DashboardController {


    @Secured("USER")
    @PostMapping("/hello")
    @ResponseBody
    String home() {
        return "Hello World!";
    }
}
