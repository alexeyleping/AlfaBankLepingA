package com.example.demo.controllers;

import com.example.demo.service.GifService;
import com.example.demo.service.RateService;
import com.example.demo.service.WealthService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AppController {

    private final RateService rateService;
    private final GifService gifService;
    private final WealthService wealthService;

    public AppController(RateService rateService, GifService gifService, WealthService wealthService) {
        this.rateService = rateService;
        this.gifService = gifService;
        this.wealthService = wealthService;

    }

    @GetMapping("/rate/USD/{currency}")//Текущий курс
    public double getCurrency(@PathVariable String currency) {
        return rateService.getRate(currency);
    }

    @GetMapping("/rate/USD/today/{currency}")//Курс сегодня больше, чем вчера?
    public boolean getCurrencyCount(@PathVariable String currency) {
        return rateService.getCourseActual(currency);
    }

    @GetMapping("/gif/random/url")//Получить случайную ссылку на картинку c тегом rich
    public String getRandomGifUrl() {
        return gifService.getRichUrl();
    }

    @GetMapping("/gif/random/url/actual/{currency}")//Получить ссылку на картинку в зависимости от курса
    public String getToGifUrl(@PathVariable String currency) {
        return wealthService.result(currency);
    }
}