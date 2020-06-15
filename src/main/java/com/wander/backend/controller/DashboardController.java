package com.wander.backend.controller;

/**
 * @author Rohit Roy
 */
import com.wander.backend.model.dto.response.CountryDataDateWise;
import com.wander.backend.model.dto.response.CountrySummary;
import com.wander.backend.model.dto.response.CountrySummaryConversion;
import com.wander.backend.model.dto.response.StateDetailList;
import com.wander.backend.service.RestClientService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping(value = "/api")
@Tag(name = "Dashboard APIs", description = "The Dashboard APIs for COVID-19 data.")
public class DashboardController {

    @Autowired
    RestClientService restClientService;

    @GetMapping("/country-wise")
    @ResponseBody
    List<CountryDataDateWise> getCountryDataDateWise(@RequestParam String from, @RequestParam String to) throws ParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        return restClientService.getCountryDataDateWise(LocalDate.parse(from, formatter), LocalDate.parse(to, formatter));
    }

    @GetMapping("/country-summary")
    @ResponseBody
    CountrySummaryConversion getCountrySummary()  {
        return restClientService.getCountrySummary();
    }

    @GetMapping("/state-data-list")
    @ResponseBody
    StateDetailList getStateDetails()  {
        return restClientService.getStateDetails();
    }
}
