package com.company;

public class Customer implements Runnable {
    private final Shop shop;
    private final String name;

    public Customer(Shop shop, int index) {
        this.name = "Покупатель " + index;
        this.shop = shop;
    }

    public void joinShop() {
        System.out.printf("%s пришел в магазин\n", getName());
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        joinShop();
        shop.buyCar();
        System.out.printf("%s уехал на новеньком авто\n", name);
    }
}
