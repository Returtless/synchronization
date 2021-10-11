package com.company;

public class Main {
    private static final int TIMEOUT = 500;
    public static final int COUNT_AUTO = 10;

    public static void main(String[] args) throws InterruptedException {
        final Shop shop = new Shop();

        Manufacturer manufacturer = new Manufacturer(shop);
        new Thread(manufacturer).start();

        for (int i = 0; i < COUNT_AUTO; i++) {
            new Thread(new Customer(shop, i)).start();
            Thread.sleep(TIMEOUT);
        }
    }
}
