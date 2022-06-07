package com.example.demo.client.gif.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GifDto {
    private final String url;

    public GifDto(@JsonProperty("url") String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}