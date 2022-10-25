package com.example.demo.Coding.MachineCoding.TinyUrl;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EncodeUrl {

    private final String charEncoding = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
    private final String domainExtension = "http://MyUrl.com/";
    String longUrl;
    int tinyUrlLength;
    Map<String,String> urlCache = new HashMap<>();
    Random random = new Random();

    public EncodeUrl(String longUrl, int tinyUrlLength) {
        this.tinyUrlLength = tinyUrlLength;
        this.longUrl = longUrl;
        encode(longUrl);
    }

    private String encode(String url) {
        if(urlCache.containsKey(url)) {
            return urlCache.get(url);
        }
        char [] tinyUrl = new char[tinyUrlLength];
        for(int i=0; i<tinyUrlLength; i++) {
            tinyUrl[i] = charEncoding.charAt(random.nextInt(charEncoding.length()));
        }
        String generatedUrl = domainExtension + new String(tinyUrl);
        urlCache.put(url,generatedUrl);

        return generatedUrl;
    }

    public String encode(){
        // check validity of URL
        try{
            validateUrl(longUrl);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // Sanitize the URL
        longUrl = sanitizeUrl(longUrl);

        return encode(longUrl);
    }

    /**
     * Remove http:// , https:// etc from URL
     *
     * @param url The URL to be sanitized
     * @return sanitize URL
     */
    private String sanitizeUrl(String url) {
        if(url.startsWith("http://")) {
            url = url.substring(7);
        }
        if(url.startsWith("https://")) {
            url = url.substring(8);
        }
        if(url.charAt(url.length()-1) == '/') {
            url = url.substring(0,url.length()-1);
        }
        return url;
    }

    private void validateUrl(String url) throws InvalidUrlException{

        if(url.startsWith("https://") || url.startsWith("http://")) {
            // OK
        } else {
            String msg = "Provide URL : " + url + " is not valid";
            throw new InvalidUrlException(msg);
        }
    }
}
