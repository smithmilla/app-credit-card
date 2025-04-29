package com.openshop.smith.models;

import java.util.ArrayList;
import java.util.List;

public class CreditCard {
    private double limit;
    private double balance;
    private List<Purchase> listPurchase;

    public CreditCard(double limit)
    {
        this.limit = limit;
        this.balance = limit;
        this.listPurchase = new ArrayList<>();
    }

    public boolean addToCreditCard(Purchase purchase)
    {
        if(this.balance > purchase.getPrice())
        {
            this.balance -= purchase.getPrice();
            this.listPurchase.add(purchase);
            return true;
        }

        return false;
    }

    public double getLimit()
    {
        return limit;
    }

    public double getBalance()
    {
        return balance;
    }

    public List<Purchase> getListPurchase()
    {
        return listPurchase;
    }
}