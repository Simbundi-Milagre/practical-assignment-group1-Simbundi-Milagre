/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hairprodduct;

/**
 *
 * @author simbu
 */
class HairValidator {

    public static boolean isValidHairType(String type) {
        return type.equalsIgnoreCase("4A")
                || type.equalsIgnoreCase("4B")
                || type.equalsIgnoreCase("4C");
    }

    public static String validatePorosity(String porosity) {
        if (porosity.equalsIgnoreCase("low")
                || porosity.equalsIgnoreCase("medium")
                || porosity.equalsIgnoreCase("high")) {
            return porosity.toLowerCase();
        }
        return "Medium"; // default
    }

    public static int validateWashes(int washes) {
        if (washes < 1) {
            return 1;
        }
        if (washes > 7) {
            return 7;
        }
        return washes;
    }
}
