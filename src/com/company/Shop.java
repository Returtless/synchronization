package com.company;

import java.util.LinkedList;

public class Shop {
    private static final int TIMEOUT = 2000;
    private final LinkedList<Auto> autoList = new LinkedList<>();

    public synchronized Auto buyCar() {
        try {
            while (autoList.isEmpty()) {
                System.out.println("Машин нет");
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return autoList.removeFirst();
    }

    public synchronized void receiveCar(Auto auto) {
        try {
            Thread.sleep(TIMEOUT);
            this.addAuto(auto);
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void addAuto(Auto auto) {
        this.autoList.add(auto);
    }
}
