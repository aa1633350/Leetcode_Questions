package com.example.demo.DesignPatterns.ObserverPattern.Observer;

public class EmailAlertImpl implements NotificationAlertObserver{
    private String emailId;

    public EmailAlertImpl(String emailId) {
        this.emailId = emailId;

    }
    @Override
    public void update() {
        sendMail(emailId, "Product back in stock");
    }

    private void sendMail(String emailId, String msg) {
        System.out.println("Mail sent to email Id "+ emailId);
    }
}
