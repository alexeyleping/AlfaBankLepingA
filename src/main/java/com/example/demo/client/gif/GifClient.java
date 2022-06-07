package com.example.demo.client.gif;

import com.example.demo.client.gif.dto.GifBaseDto;
import com.example.demo.client.gif.dto.GifDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "gif-client", url = "${git.api.base.url}")
public interface GifClient {
    @GetMapping
    GifDto getGif(@RequestParam("api_key") String app_id,
                  @RequestParam("tag") String q,
                  @RequestParam("rating") String appRating);

    @GetMapping("/random")
    GifBaseDto getRandomUrl(@RequestParam("api_key") String apiKey, @RequestParam("tag") String q);
}