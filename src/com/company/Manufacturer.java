package com.company;

public class Manufacturer implements Runnable {
    private int maxSellAuto = 10;

    private final Shop shop;

    public Manufacturer(Shop shop) {
        this.shop = shop;
    }

    public Auto createAuto(String brand) {
        System.out.printf("Производитель %s выпустил автомобиль\n", brand);
        return new Auto();
    }

    @Override
    public void run() {
        while (maxSellAuto != 0) {
            shop.receiveCar(createAuto("Toyota"));
            maxSellAuto--;
        }
    }
}
