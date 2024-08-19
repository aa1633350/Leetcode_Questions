package com.example.demo.MachineCodingPractice.ApiRetries_Twilio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ApiRetryService {

    private static final int MAX_RETRIES = 3;
    private static final long BACKOFF_TIME = 3000; // in milliseconds

    public static void main(String[] args) throws Exception {
        String response = fetchResponseWithRetries("https://twilio.com");
    }

    private static String fetchResponseWithRetries(String url) throws Exception {
        int retryCount = 0;
        long backOfTime = BACKOFF_TIME;
        while(retryCount < MAX_RETRIES) {
            try {
                return makeApiCall(url);
            } catch (Exception e) {
                retryCount++;
                if(retryCount >= MAX_RETRIES) {
                    e.printStackTrace();
                }
                System.out.println("API call failed .. Retrying in " + backOfTime);
                try {
                    Thread.sleep(backOfTime);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    throw new Exception("Retry interrupted ", ex);

                }
                backOfTime = backOfTime*2;

            }
        }
        throw new Exception("max retries exceeded");

    }

    private static String makeApiCall(String url) {
        HttpURLConnection connection = null;
        try {
            URL apiUrl = new URL(url);

            connection = (HttpURLConnection) apiUrl.openConnection();
            connection.setRequestMethod("GET");
            if(connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader responseReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                return "";
                // process the stream.
            } else {
                throw new IOException("Http error code " + connection.getResponseCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(connection != null) {
                connection.disconnect();
            }
        }
        return "response";

    }
}
