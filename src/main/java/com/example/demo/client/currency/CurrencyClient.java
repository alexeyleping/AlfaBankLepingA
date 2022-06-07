package com.example.demo.client.currency;

import com.example.demo.client.currency.dto.CurrencyDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "currency-client", url = "${currency.base.url}")
public interface CurrencyClient {
    @GetMapping("/historical/{date}.json")
    CurrencyDto getCurrencies(@PathVariable("date") String date,
                              @RequestParam("app_id") String appId);
}