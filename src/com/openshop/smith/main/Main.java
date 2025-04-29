package com.openshop.smith.main;

import com.openshop.smith.models.CreditCard;
import com.openshop.smith.models.Purchase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        CreditCard creditCard;
        int optionValue = 1;

        double purchaseValue = 0.00;
        String purchaseName = "";
        double creditCardLimit = 0.00;
        boolean purchaseMade;

        String messagePanel = """
                
                -----------------------------------------
                PANEL DE OPCIONES
                -----------------------------------------
                1.- Ingresar nuevo articulo
                0.- Salir
                """;



        System.out.print("Ingrese el límite de la tarjeta: ");
        creditCardLimit = scn.nextDouble();
        creditCard = new CreditCard(creditCardLimit);

        while(optionValue != 0)
        {

            System.out.print("\nEscriba la descripción de la compra: ");
            purchaseName = scn.next();
            System.out.print("Escriba el valor de la compra: ");
            purchaseValue = scn.nextDouble();

            Purchase purchase = new Purchase(purchaseName, purchaseValue);
            purchaseMade = creditCard.addToCreditCard(purchase);

            if(purchaseMade)
            {
                System.out.println("Compra realizada!");
                System.out.println(messagePanel);
                optionValue = scn.nextInt();
            }
            else
            {
                optionValue = 0;
            }

        }


        if(!creditCard.getListPurchase().isEmpty())
        {

            System.out.println("\n----------------------------");
            System.out.println(" COMPRAS REALIZADAS \n");
            Collections.sort(creditCard.getListPurchase());
            /*creditCard.getListPurchase().sort(Comparator.comparing(Purchase::getPrice));*/
            creditCard.getListPurchase().forEach(purchase -> {
                System.out.println(purchase.getName() + " - " + purchase.getPrice());
            });
            System.out.println("\n----------------------------");
            System.out.println("\nSaldo de la tarjeta: " + creditCard.getBalance());
        }
    }
}
