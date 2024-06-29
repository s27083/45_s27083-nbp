package com.example.s27083nbp.Models;

import io.swagger.v3.oas.annotations.media.Schema;

public class Rate {
    @Schema(description = "Rate number", example = "125/A/NBP/2024")
    private String no;

    @Schema(description = "Effective date", example = "2024-06-28")
    private String effectiveDate;

    @Schema(description = "Mid exchange rate", example = "4.4813")
    private double mid;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public double getMid() {
        return mid;
    }

    public void setMid(double mid) {
        this.mid = mid;
    }
}