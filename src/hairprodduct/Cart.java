/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hairprodduct;

import java.util.ArrayList;

/**
 *
 * @author simbu
 */
class Cart {

    private ArrayList<HairProduct> items = new ArrayList<>();

    public void addProduct(HairProduct p) {
        items.add(p);
    }

    public void showCart() {
        if (items.isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println("Your cart contains:");
            for (HairProduct p : items) {
                System.out.println("- " + p);
            }
            System.out.println("Total: R" + calculateTotal());
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (HairProduct p : items) {
            total += p.getPrice();
        }
        return total;
    }

    public ArrayList<HairProduct> getItems() {
        return items;
    }

}
