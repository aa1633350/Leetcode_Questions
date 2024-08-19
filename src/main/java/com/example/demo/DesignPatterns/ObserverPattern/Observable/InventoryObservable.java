package com.example.demo.DesignPatterns.ObserverPattern.Observable;

import com.example.demo.DesignPatterns.ObserverPattern.Observer.NotificationAlertObserver;

public interface InventoryObservable {

    void add(NotificationAlertObserver observer);
    void remove(NotificationAlertObserver observer);
    void setData(int stockCount);
    void notifyUser();
}
