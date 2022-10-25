package com.example.demo.Coding.MachineCoding.TinyUrl;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please provide the URL to encode");
        String longUrl = sc.next();
        EncodeUrl encodeUrl = new EncodeUrl(longUrl,7);
        String generatedUrl = encodeUrl.encode();
        System.out.println("Generated tiny url for original URL : " + longUrl + " is " + generatedUrl);
    }
}
