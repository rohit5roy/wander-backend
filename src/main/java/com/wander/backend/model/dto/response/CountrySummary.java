package com.wander.backend.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Rohit Roy
 */
@Data
public class CountrySummary {

    @JsonProperty("Active cases")
    private String activeCases;
    @JsonProperty("Cured/Discharged/Migrated")
    private String cured;
    @JsonProperty("Death")
    private String death;
    @JsonProperty("Total Cases")
    private String total;
}
