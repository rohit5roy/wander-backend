package com.wander.backend.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Rohit Roy
 */
@Data
public class CountrySummaryConversion {

    @JsonProperty("active")
    private String activeCases;
    @JsonProperty("cured")
    private String cured;
    @JsonProperty("death")
    private String death;
    @JsonProperty("total")
    private String total;
}
