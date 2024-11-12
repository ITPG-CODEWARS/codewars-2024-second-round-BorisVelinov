package com.example.urlshortener.controller;

import com.example.urlshortener.model.Url;
import com.example.urlshortener.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/url")
public class UrlController {
    @Autowired
    private UrlService urlService;

    @PostMapping("/create")
    public Url createShortUrl(@RequestParam String longUrl,
                              @RequestParam(required = false) String customAlias,
                              @RequestParam(defaultValue = "10") int maxUses,
                              @RequestParam(required = false) LocalDateTime expirationDate) {
        return urlService.createShortUrl(longUrl, customAlias, maxUses, expirationDate);
    }
}
