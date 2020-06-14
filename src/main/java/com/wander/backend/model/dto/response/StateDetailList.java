package com.wander.backend.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author Rohit Roy
 */
@Data
public class StateDetailList {

    @JsonProperty("state")
    List<StateDataDetails> detailsList;
}
