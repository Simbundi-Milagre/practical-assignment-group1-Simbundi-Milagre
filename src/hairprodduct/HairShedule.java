/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hairprodduct;

/**
 *
 * @author simbu
 */
public class HairShedule {

    private String[] schedule;

    public String[] getSchedule() {
        return schedule;
    }

    public HairShedule(int washesPerWeek, String porosity) {
        schedule = new String[washesPerWeek * 4]; // 4 weeks
        generateSchedule(porosity);
    }

    private void generateSchedule(String porosity) {
        String[] treatments;

        if (porosity.equalsIgnoreCase("low")) {
            treatments = new String[]{"Hydration", "Hydration", "Nutrition", "Reconstruction"};
        } else if (porosity.equalsIgnoreCase("medium")) {
            treatments = new String[]{"Hydration", "Nutrition", "Reconstruction"};
        } else if (porosity.equalsIgnoreCase("high")) {
            treatments = new String[]{"Reconstruction", "Nutrition", "Hydration"};
        } else {
            treatments = new String[]{"Hydration", "Nutrition", "Reconstruction"};
        }

        int treatmentIndex = 0;
        for (int i = 0; i < schedule.length; i++) {
            schedule[i] = treatments[treatmentIndex];
            treatmentIndex++;
            if (treatmentIndex == treatments.length) {
                treatmentIndex = 0; // restart
            }
        }
    }

    public void showSchedule() {
        System.out.println("\nYour Monthly Hair Schedule:");
        for (int i = 0; i < schedule.length; i++) {
            System.out.println("Day " + (i + 1) + ": " + schedule[i]);
        }
    }
}
