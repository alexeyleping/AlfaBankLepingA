package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class WealthService {
    private GifService gifService;
    private RateService rateService;
    private boolean isRich = true;

    public WealthService(GifService gifService, RateService rateService) {
        this.gifService = gifService;
        this.rateService = rateService;
    }

    public String result(String currency){
        isRich = rateService.getCourseActual(currency);
        if(isRich == true){
            return gifService.getRichUrl();
        }
        else
            return gifService.getBrokeUrl();
    }
}