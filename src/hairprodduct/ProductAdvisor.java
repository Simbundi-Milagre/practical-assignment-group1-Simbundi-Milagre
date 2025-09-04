/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hairprodduct;

/**
 *
 * @author simbu
 */
import java.util.ArrayList;

public class ProductAdvisor {

    public static HairProduct[] recommendProducts(String hairType, String porosity) {
        ArrayList<HairProduct> products = new ArrayList<>();

        // Shampoo recommendations
        if (hairType.equalsIgnoreCase("4A")) {
            products.add(new Shampoo("Moisturizing Shampoo 4A", 110));
        } else if (hairType.equalsIgnoreCase("4B")) {
            products.add(new Shampoo("Hydrating Shampoo 4B", 120));
        } else {
            products.add(new Shampoo("Deep Cleanse Shampoo 4C", 130));
        }

        // Conditioner recommendations
        if (porosity.equalsIgnoreCase("low")) {
            products.add(new Conditioner("Light Leave-In Conditioner", 90));
        } else if (porosity.equalsIgnoreCase("medium")) {
            products.add(new Conditioner("Balanced Conditioner", 95));
        } else {
            products.add(new Conditioner("Rich Moisturizing Conditioner", 100));
        }

        // Mask recommendations
        if (porosity.equalsIgnoreCase("low")) {
            products.add(new Mask("Hydrating Shea Butter Mask", 150));
        } else if (porosity.equalsIgnoreCase("medium")) {
            products.add(new Mask("Balanced Hair Mask", 140));
        } else {
            products.add(new Mask("Protein Reconstruction Mask", 160));
        }

        return products.toArray(new HairProduct[0]);
    }
}
