package com.openshop.smith.models;

public class Purchase implements Comparable<Purchase>{
    private String name;
    private double price;

    public Purchase(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "\n" + this.getName() + " - " + this.getPrice();
    }

    @Override
    public int compareTo(Purchase otherPurchase) {
        return Double.valueOf(this.price)
                .compareTo(
                        Double.valueOf(otherPurchase.getPrice())
                );
    }
}
