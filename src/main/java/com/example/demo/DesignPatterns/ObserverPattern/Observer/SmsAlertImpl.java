package com.example.demo.DesignPatterns.ObserverPattern.Observer;

public class SmsAlertImpl implements NotificationAlertObserver {
    private String mobileNo;
    public SmsAlertImpl(String mobileNo) {
        this.mobileNo=mobileNo;

    }
    @Override
    public void update() {
        sendSmsAlert(mobileNo, "Product back in stock");
    }

    private void sendSmsAlert(String mobileNo, String msg) {
        System.out.println("Sms sent to mobile : " + mobileNo);
    }
}
