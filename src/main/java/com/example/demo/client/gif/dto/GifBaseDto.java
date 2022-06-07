package com.example.demo.client.gif.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GifBaseDto {
    private final GifDto data;

    public GifBaseDto(@JsonProperty("data") GifDto data) {
        this.data = data;
    }

    public GifDto getData() {
        return data;
    }
}