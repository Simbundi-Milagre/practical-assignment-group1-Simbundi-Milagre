/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hairprodduct;

/**
 *
 * @author simbu
 */

class HairProduct {
    private String name;
    private double price;

    public HairProduct(String name, double price) {
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
        return name + " - R" + price;
    }
}




