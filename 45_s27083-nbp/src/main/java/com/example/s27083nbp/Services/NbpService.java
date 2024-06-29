package com.example.s27083nbp.Services;

import com.example.s27083nbp.Models.NbpResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NbpService {

    private final RestTemplate restTemplate;
    private final QueryLogService queryLogService;
    public NbpService(QueryLogService queryLogService, RestTemplate restTemplate, QueryLogService queryLogService1) {

        this.restTemplate = restTemplate;
        this.queryLogService = queryLogService1;
    }

    public NbpResponse getAverageRate(String currency, String startDate, String endDate) {
        String url = String.format("http://api.nbp.pl/api/exchangerates/rates/A/%s/%s/%s/?format=json", currency, startDate, endDate);
        NbpResponse response = restTemplate.getForObject(url, NbpResponse.class);
        response.setAverageRate(calculateAverageRate(response));
        queryLogService.saveQueryLog(currency, startDate, endDate, response.getAverageRate());

        return response;
    }
    public double calculateAverageRate(NbpResponse response) {
        if (response != null && response.getRates() != null) {
            return response.getRates().stream()
                    .mapToDouble(rate -> rate.getMid())
                    .average()
                    .orElse(0.0);
        } else {
            throw new RuntimeException("Error calculating average rate");
        }
    }
}
