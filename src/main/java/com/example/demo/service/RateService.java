package com.example.demo.service;

import com.example.demo.client.currency.CurrencyClient;
import com.example.demo.client.currency.dto.CurrencyDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class RateService {
    private final String appId;
    private final CurrencyClient currencyClient;

    public RateService(@Value("${currency.api.id}") String currencyApiId,
                       CurrencyClient currencyClient) {
        this.appId = currencyApiId;
        this.currencyClient = currencyClient;
    }

    public boolean getCourseActual(String currency) {
        if (getRate(currency) > yesterdayRate(currency)) {
            return true;
        }
        return false;
    }

    public double getRate(String currency) {
        String today = LocalDate.now().toString();
        CurrencyDto currencies = currencyClient.getCurrencies(today, appId);
        return currencies.getRates().get(currency);
    }

    public double yesterdayRate(String currency) {
        String yesterday = LocalDate.now().minusDays(1).toString();
        CurrencyDto currencies = currencyClient.getCurrencies(yesterday, appId);
        return currencies.getRates().get(currency);
    }
}