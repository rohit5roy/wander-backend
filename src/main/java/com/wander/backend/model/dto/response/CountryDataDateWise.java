package com.wander.backend.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * @author Rohit Roy
 */
@Data
public class CountryDataDateWise {

    @JsonProperty("Country")
    private String country;
    @JsonProperty("CountryCode")
    private String countryCode;
    @JsonProperty("Province")
    private String province;
    @JsonProperty("City")
    private String city;
    @JsonProperty("CityCode")
    private String cityCode;
    @JsonProperty("Lat")
    private String lat;
    @JsonProperty("Lon")
    private String lon;
    @JsonProperty("Cases")
    private Integer cases;
    @JsonProperty("Status")
    private String status;
    @JsonProperty("Date")
    private String date;
}
