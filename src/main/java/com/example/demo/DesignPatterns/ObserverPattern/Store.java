package com.example.demo.DesignPatterns.ObserverPattern;

import com.example.demo.DesignPatterns.ObserverPattern.Observable.InventoryObservable;
import com.example.demo.DesignPatterns.ObserverPattern.Observable.IphoneObservable;
import com.example.demo.DesignPatterns.ObserverPattern.Observable.WashingMachineObservable;
import com.example.demo.DesignPatterns.ObserverPattern.Observer.EmailAlertImpl;
import com.example.demo.DesignPatterns.ObserverPattern.Observer.NotificationAlertObserver;
import com.example.demo.DesignPatterns.ObserverPattern.Observer.SmsAlertImpl;

public class Store {

    public static void main(String[] args) {
        InventoryObservable iphoneObservable = new IphoneObservable();

        NotificationAlertObserver observer1 = new EmailAlertImpl("aa1633350@gmail.com");
        NotificationAlertObserver observer2 = new EmailAlertImpl("zxc@gmail.com");
        NotificationAlertObserver observer3 = new SmsAlertImpl("97654321");

        iphoneObservable.add(observer1);
        iphoneObservable.add(observer2);
        iphoneObservable.add(observer3);

        iphoneObservable.setData(10);

        InventoryObservable washingMachineObservable = new WashingMachineObservable();
        washingMachineObservable.add(observer1);
        washingMachineObservable.setData(5);

    }
}
