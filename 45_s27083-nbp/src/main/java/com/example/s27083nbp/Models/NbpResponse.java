package com.example.s27083nbp.Models;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Collection;
import java.util.List;


import java.util.List;

public class NbpResponse {
    @Schema(description = "Currency name", example = "frank szwajcarski")
    private String currency;

    @Schema(description = "Currency code", example = "CHF")
    private String code;

    @Schema(description = "List of rates")
    private List<Rate> rates;


    public Double getAverageRate() {
        return averageRate;
    }

    public void setAverageRate(Double averageRate) {
        this.averageRate = averageRate;
    }

    private Double averageRate;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }
}


