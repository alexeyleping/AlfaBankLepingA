package com.example.demo.client.currency.dto;

import java.util.Map;

public class CurrencyDto {
    private final String disclaimer;
    private final String license;
    private final long timestamp;
    private final String base;
    private final Map<String, Double> rates;

    public CurrencyDto(String disclaimer, String license, long timestamp, String base, Map<String, Double> rates) {
        this.disclaimer = disclaimer;
        this.license = license;
        this.timestamp = timestamp;
        this.base = base;
        this.rates = rates;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public String getLicense() {
        return license;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getBase() {
        return base;
    }

    public Map<String, Double> getRates() {
        return rates;
    }
}