package com.turchenkov.Observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Observable
 */
interface Observable {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver();
}

/**
 * Observer
 */
interface Observer {
    void update(Object object);
}

public class Program {
    public static void main(String[] args) {
        Stock stock = new Stock();
        Bank bank = new Bank("Bank", stock);
        Broker broker = new Broker("Broker", stock);
        stock.market();

        broker.stopTrade();

        stock.market();
    }
}

class Stock implements Observable {

    private StockInfo stockInfo;

    private List<Observer> observers;

    Stock() {
        stockInfo = new StockInfo();
        this.observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(stockInfo);
        }
    }

    void market() {
        Random random = new Random();
        stockInfo.setEuro(random.nextInt(50));
        stockInfo.setUsd(random.nextInt(20));
        notifyObserver();
    }
}

class Broker implements Observer {

    private String name;

    /**
     * stock
     */
    private Observable observable;

    Broker(String name, Observable observable) {
        this.name = name;
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Object object) {
        StockInfo stockInfo = (StockInfo) object;
        if (stockInfo.getEuro() > 30) {
            System.out.println(this.name + " buy USD by " + stockInfo.getUsd());
        } else {
            System.out.println(this.name + " sell USD by " + stockInfo.getUsd());
        }
    }

    void stopTrade() {
        observable.removeObserver(this);
        observable = null;
    }
}

class Bank implements Observer {

    private String name;

    /**
     * stock
     */
    private Observable observable;

    Bank(String name, Observable observable) {
        this.name = name;
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Object object) {
        StockInfo stockInfo = (StockInfo) object;
        if (stockInfo.getEuro() > 30) {
            System.out.println(this.name + " buy EURO by " + stockInfo.getUsd());
        } else {
            System.out.println(this.name + " sell EURO by " + stockInfo.getUsd());
        }
    }
}


class StockInfo {
    private int usd;
    private int euro;

    int getUsd() {
        return usd;
    }

    void setUsd(int usd) {
        this.usd = usd;
    }

    int getEuro() {
        return euro;
    }

    void setEuro(int euro) {
        this.euro = euro;
    }
}