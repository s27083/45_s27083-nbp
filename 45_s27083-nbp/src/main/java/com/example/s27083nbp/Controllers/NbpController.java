package com.example.s27083nbp.Controllers;

import com.example.s27083nbp.Models.NbpResponse;
import com.example.s27083nbp.Services.NbpService;
import com.example.s27083nbp.Services.QueryLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class NbpController {
    @Autowired
    private NbpService nbpService;

    @Autowired
    private QueryLogService queryLogService;

    @GetMapping("/average-rate")
    public NbpResponse getAverageRate(@RequestParam String currency, @RequestParam String startDate, @RequestParam String endDate) {
        NbpResponse averageRate = nbpService.getAverageRate(currency, startDate, endDate);
        return averageRate;
    }
}