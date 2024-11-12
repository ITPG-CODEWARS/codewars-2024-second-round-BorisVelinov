package com.example.urlshortener.service;

import com.example.urlshortener.model.Url;
import com.example.urlshortener.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class UrlService {

    @Autowired
    private UrlRepository urlRepository;

    public Url createShortUrl(String longUrl, String customAlias, int maxUses, LocalDateTime expirationDate) {
        Url url = new Url();
        url.setLongUrl(longUrl);
        url.setShortUrl(customAlias != null ? customAlias : generateRandomString(7));
        url.setCreationDate(LocalDateTime.now());
        url.setMaxUses(maxUses);
        url.setExpirationDate(expirationDate);
        return urlRepository.save(url);
    }

    private String generateRandomString(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random rand = new Random();
        StringBuilder shortUrl = new StringBuilder();

        for (int i = 0; i < length; i++) {
            shortUrl.append(chars.charAt(rand.nextInt(chars.length())));
        }
        return shortUrl.toString();
    }
}
