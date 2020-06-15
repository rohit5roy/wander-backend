package com.wander.backend.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginRequestDTO {

    @JsonProperty("UserName")
    @NotBlank
    private String userName;

    @NotBlank
    @JsonProperty("Password")
    private String password;
}
