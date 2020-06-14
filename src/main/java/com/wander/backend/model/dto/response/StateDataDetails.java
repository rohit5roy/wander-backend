package com.wander.backend.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Rohit Roy
 */
@Data
public class StateDataDetails {

    @JsonProperty("_id")
    private String id;
    @JsonProperty("active")
    private String active;
    @JsonProperty("cured")
    private String cured;
    @JsonProperty("death")
    private String death;
    @JsonProperty("total")
    private String total;
    @JsonProperty("name")
    private String name;
}
