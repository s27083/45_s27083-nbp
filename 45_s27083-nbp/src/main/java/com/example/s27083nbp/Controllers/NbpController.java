package com.example.s27083nbp.Controllers;

import com.example.s27083nbp.Models.NbpResponse;
import com.example.s27083nbp.Services.NbpService;
import com.example.s27083nbp.Services.QueryLogService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class NbpController {
    @Autowired
    private NbpService nbpService;

    @Autowired
    private QueryLogService queryLogService;

    @Operation(summary = "Get exchange rate", description = "Get the average exchange rate for specific currency code and date range")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success"),
            @ApiResponse(responseCode = "400", description = "Bad request"),
            @ApiResponse(responseCode = "400", description = "Przekroczony limit"),
            @ApiResponse(responseCode = "404", description = "Data not found bad date range or currecny"),
            @ApiResponse(responseCode = "500", description = "Application error")
    })
    @GetMapping("/average-rate")
    public NbpResponse getAverageRate(
            @Parameter(description = "Currency code for ex CHF") @RequestParam String currency,
            @Parameter(description = "Start date in format YYYY-MM-DD") @RequestParam String startDate,
            @Parameter(description = "End date in format YYYY-MM-DD") @RequestParam String endDate) {
        NbpResponse response = nbpService.getAverageRate(currency, startDate, endDate);
        return response;
    }
}