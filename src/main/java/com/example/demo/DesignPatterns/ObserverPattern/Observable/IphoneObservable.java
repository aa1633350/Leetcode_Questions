package com.example.demo.DesignPatterns.ObserverPattern.Observable;

import com.example.demo.DesignPatterns.ObserverPattern.Observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservable implements InventoryObservable {

    public List<NotificationAlertObserver> iphoneObserverList = new ArrayList<>();
    public int stockCount = 0;
    @Override
    public void add(NotificationAlertObserver observer) {
        iphoneObserverList.add(observer);
    }

    @Override
    public void remove(NotificationAlertObserver observer) {
        iphoneObserverList.remove(observer);
    }

    @Override
    public void setData(int newStockCount) {
        if(stockCount == 0 && newStockCount > 0) {
            notifyUser();
        }

        stockCount += newStockCount;
    }

    @Override
    public void notifyUser() {
        for(NotificationAlertObserver notificationObserver : iphoneObserverList) {
            notificationObserver.update();
        }
    }
}
