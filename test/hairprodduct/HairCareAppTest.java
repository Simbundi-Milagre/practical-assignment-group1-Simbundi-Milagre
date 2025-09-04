/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package hairprodduct;

import org.junit.Test;
import org.junit.Assert;

/**
 *
 * @author simbu
 */
public class HairCareAppTest {

    // HairSchedule Tests 
    @Test
    public void testLowPorositySchedule() {
        HairShedule schedule = new HairShedule(3, "low"); // 3 washes/week, low porosity
        String[] result = schedule.getSchedule();

        String expectedFirstDay = "Hydration";
        Assert.assertEquals(expectedFirstDay, result[0]);

        int expectedLength = 3 * 4; // 3 washes * 4 weeks
        int resultLength = result.length;
        Assert.assertEquals(expectedLength, resultLength);
    }

    @Test
    public void testHighPorositySchedule() {
        HairShedule schedule = new HairShedule(2, "high"); // 2 washes/week, high porosity
        String[] result = schedule.getSchedule();

        String expectedFirstDay = "Reconstruction";
        String resultFirstDay = result[0];
        Assert.assertEquals(expectedFirstDay, resultFirstDay);

        int expectedLength = 2 * 4; // 2 washes * 4 weeks
        int resultLength = result.length;
        Assert.assertEquals(expectedLength, resultLength);
    }

    //ProductAdvisor Tests 
    @Test
    public void testProductRecommendation4ALow() {
        HairProduct[] result = ProductAdvisor.recommendProducts("4A", "low");

        int expectedLength = 3;
        int resultLength = result.length;
        Assert.assertEquals(expectedLength, resultLength);

        String expectedFirstProduct = "Moisturizing Shampoo 4A";
        Assert.assertEquals(expectedFirstProduct, result[0].getName());

        String expectedLastProduct = "Hydrating Shea Butter Mask";
        Assert.assertEquals(expectedLastProduct, result[2].getName());
    }

    @Test
    public void testProductRecommendation4CHigh() {
        HairProduct[] result = ProductAdvisor.recommendProducts("4C", "high");

        int expectedLength = 3;
        int resultLength = result.length;
        Assert.assertEquals(expectedLength, resultLength);

        String expectedFirstProduct = "Deep Cleanse Shampoo 4C";
        Assert.assertEquals(expectedFirstProduct, result[0].getName());

        double expectedLastPrice = 160.0;
        double resultLastPrice = result[2].getPrice();
        Assert.assertEquals(expectedLastPrice, resultLastPrice, 0.01);
    }

    // Cart Tests 
    @Test
    public void testAddSingleProductToCart() {
        Cart cart = new Cart();
        HairProduct shampoo = new Shampoo("Moisturizing Shampoo", 120);
        cart.addProduct(shampoo);

        int expectedSize = 1;
        int resultSize = cart.getItems().size();
        Assert.assertEquals(expectedSize, resultSize);

        double expectedTotal = 120.0;
        double resultTotal = cart.calculateTotal();
        Assert.assertEquals(expectedTotal, resultTotal, 0.01);
    }

    @Test
    public void testAddMultipleProductsToCart() {
        Cart cart = new Cart();
        HairProduct shampoo = new Shampoo("Moisturizing Shampoo", 120);
        HairProduct mask = new Mask("Hydrating Mask", 150);
        cart.addProduct(shampoo);
        cart.addProduct(mask);

        int expectedSize = 2;
        int resultSize = cart.getItems().size();
        Assert.assertEquals(expectedSize, resultSize);

        double expectedTotal = 270.0;
        double resultTotal = cart.calculateTotal();
        Assert.assertEquals(expectedTotal, resultTotal, 0.01);
    }
}
