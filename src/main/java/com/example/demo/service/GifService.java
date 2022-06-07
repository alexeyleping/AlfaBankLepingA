package com.example.demo.service;

import com.example.demo.client.gif.GifClient;
import com.example.demo.client.gif.dto.GifBaseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GifService {
    private final String gifApiKey;
    private final GifClient gifClient;
    private String gifKeyRich = "rich";
    private String gifKeyBroke = "broke";

    public GifService(@Value("${gif.api.key}") String gifApiKey,
                      GifClient gifClient) {
        this.gifApiKey = gifApiKey;
        this.gifClient = gifClient;
    }

    public String getRichUrl() {
        GifBaseDto gifBaseDto = gifClient.getRandomUrl(gifApiKey, gifKeyRich);
        return gifBaseDto.getData().getUrl();
    }

    public String getBrokeUrl() {
        GifBaseDto gifBaseDto = gifClient.getRandomUrl(gifApiKey, gifKeyBroke);
        return gifBaseDto.getData().getUrl();
    }
}