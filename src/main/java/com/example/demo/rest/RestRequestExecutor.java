package com.example.demo.rest;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class RestRequestExecutor {

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        Transcript transcript = new Transcript();
        transcript.setAudio_url("some url");
        Gson gson = new Gson();
        String postRequestBody = gson.toJson(transcript);
        System.out.println(postRequestBody);

        HttpRequest postRequest = HttpRequest.newBuilder()
                .uri(new URI("https://api.assemblyai.com/v2/transcript"))
                .header("Authorization", Constants.API_KEY)
                .POST(HttpRequest.BodyPublishers.ofString(postRequestBody))
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> postResponse = httpClient.send(postRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(postResponse.body());




    }
}
