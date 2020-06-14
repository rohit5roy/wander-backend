package com.wander.backend.service;

import com.wander.backend.model.dto.response.CountryDataDateWise;
import com.wander.backend.model.dto.response.CountrySummary;
import com.wander.backend.model.dto.response.StateDataDetails;
import com.wander.backend.model.dto.response.StateDetailList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * @author Rohit Roy
 */
@Component
@Slf4j
public class RestClientService {

    @Autowired
    RestTemplate restTemplate;

    public List<CountryDataDateWise> getCountryDataDateWise(LocalDate fromDate, LocalDate toDate) {
        String host = "https://api.covid19api.com/country/india/status/confirmed?from=";
        ResponseEntity<CountryDataDateWise[]> response = restTemplate.getForEntity(host + fromDate + "&to=" + toDate  , CountryDataDateWise[].class);
        CountryDataDateWise[] data = response.getBody();
        return Arrays.asList(data);
    }

    public CountrySummary getCountrySummary() {
        String host = "http://covid19-india-adhikansh.herokuapp.com/summary";
        CountrySummary response = restTemplate.getForObject(host , CountrySummary.class);
        return response;
    }


    public StateDetailList getStateDetails() {
        String host = "http://covid19-india-adhikansh.herokuapp.com/states";
        StateDetailList response = restTemplate.getForObject(host , StateDetailList.class);
        return response;
    }


}

