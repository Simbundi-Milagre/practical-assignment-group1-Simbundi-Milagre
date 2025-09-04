/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hairprodduct;

/**
 *
 * @author simbu
 */
import java.util.Scanner;

public class HairCareApp {

    public static void main(String[] args) {
        int washes;
        String hairType;
        String porosity;

        Scanner scanner = new Scanner(System.in);

        // Step 1: Gather user info
        while (true) {
            System.out.print("Enter your hair type (4A, 4B, 4C): ");
            hairType = scanner.nextLine().toUpperCase();
            if (HairValidator.isValidHairType(hairType)) {
                break; // valid input, exit loop
            } else {
                System.out.println("Invalid hair type! Please enter 4A, 4B, or 4C.");
            }
        }

        while (true) {
            System.out.print("Enter hair porosity (Low, Medium, High): ");
            porosity = scanner.nextLine().toLowerCase();
            if (porosity.equals("low") || porosity.equals("medium") || porosity.equals("high")) {
                break; // valid
            } else {
                System.out.println("Invalid porosity! Please enter Low, Medium, or High.");
            }
        }

        while (true) {
            System.out.print("How many times per week do you wash your hair? ");
            if (scanner.hasNextInt()) {
                washes = scanner.nextInt();
                scanner.nextLine(); // clear buffer
                if (washes >= 1 && washes <= 7) {
                    break; // valid
                } else {
                    System.out.println("Please enter a number between 1 and 7.");
                }
            } else {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); // clear invalid input
            }
        }

        // Step 2: Generate schedule
        HairShedule schedule = new HairShedule(washes, porosity);
        schedule.showSchedule();

        // Step 3: Show product recommendations
        HairProduct[] products = ProductAdvisor.recommendProducts(hairType, porosity);
        System.out.println("\nRecommended Products:");
        for (int i = 0; i < products.length; i++) {
            System.out.println((i + 1) + ". " + products[i]);
        }

        // Step 4: Shopping cart
        Cart cart = new Cart();
        System.out.println("\nWould you like to:\n1. Buy ALL products\n2. Select specific products\n3. Cancel");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            for (HairProduct p : products) {
                cart.addProduct(p);
            }
        } else if (choice == 2) {
            System.out.print("Enter product numbers separated by commas (e.g. 1,3): ");
            String input = scanner.nextLine();
            String[] selections = input.split(",");
            for (String s : selections) {
                int index = Integer.parseInt(s.trim()) - 1;
                if (index >= 0 && index < products.length) {
                    cart.addProduct(products[index]);
                }
            }
        }

        // Step 5: Show final cart
        cart.showCart();

        System.out.println("\nThank you for using the HairCare App, beautiful " + hairType + " queen!");
    }
}
