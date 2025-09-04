/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seriesmodel;

/**
 *
 * @author simbu
 */
import java.util.Scanner;

public class Series {

    private SeriesModel[] seriesList = new SeriesModel[100]; // store up to 100 series
    private int seriesCount = 0;
    private Scanner scanner = new Scanner(System.in);

    //RUN MENU 
    public void run() {
        System.out.println("LATEST SERIES - 2025");
        System.out.println("*******************************");

        while (true) {
            System.out.println("\nPlease select one of the following menu items:");
            System.out.println("(1) Capture a new series.");
            System.out.println("(2) Search for a series.");
            System.out.println("(3) Update series.");
            System.out.println("(4) Delete a series.");
            System.out.println("(5) Print series report.");
            System.out.println("(6) Exit Application.");

            System.out.print("Choose option: ");
            String option = scanner.nextLine();

            if (option.equals("1")) {
                captureSeriesMenu();
            } else if (option.equals("2")) {
                searchSeriesMenu();
            } else if (option.equals("3")) {
                updateSeriesMenu();
            } else if (option.equals("4")) {
                deleteSeriesMenu();
            } else if (option.equals("5")) {
                printReportMenu();
            } else if (option.equals("6")) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid option. Try again.");
            }

            System.out.print("\nPress 1 to launch the menu again or any other key to exit: ");
            String again = scanner.nextLine();
            if (!again.equals("1")) {
                System.out.println("Goodbye!");
                break;
            }
        }
    }

    // PRIVATE MENU METHODS 
    private void captureSeriesMenu() {
        SeriesModel s = new SeriesModel();

        System.out.print("Enter the series ID: ");
        s.setSeriesID(scanner.nextLine());

        System.out.print("Enter the series name: ");
        s.setSeriesName(scanner.nextLine());

        while (true) {
            System.out.print("Enter the series age restriction (2-18): ");
            s.setSeriesAge(scanner.nextLine());
            if (s.checkSeriesAge()) {
                break;
            } else {
                System.out.println("Invalid age! Please enter a number between 2 and 18.");
            }
        }

        System.out.print("Enter the number of episodes: ");
        s.setSeriesNumberOfEpisodes(scanner.nextLine());

        addSeries(s);
        System.out.println("Series added successfully!");
    }

    private void searchSeriesMenu() {
        System.out.print("Enter the series ID to search: ");
        String id = scanner.nextLine();

        SeriesModel s = findSeriesById(id);
        if (s != null) {
            System.out.println(s);
        } else {
            System.out.println("Series with ID " + id + " not found!");
        }
    }

    private void updateSeriesMenu() {
        System.out.print("Enter the series ID to update: ");
        String id = scanner.nextLine();

        SeriesModel s = findSeriesById(id);
        if (s != null) {
            System.out.print("Enter new series name: ");
            s.setSeriesName(scanner.nextLine());

            while (true) {
                System.out.print("Enter new series age restriction (2-18): ");
                s.setSeriesAge(scanner.nextLine());
                if (s.checkSeriesAge()) {
                    break;
                } else {
                    System.out.println("Invalid age! Please enter a number between 2 and 18.");
                }
            }

            System.out.print("Enter new number of episodes: ");
            s.setSeriesNumberOfEpisodes(scanner.nextLine());

            System.out.println("Series updated successfully!");
        } else {
            System.out.println("Series with ID " + id + " not found.");
        }
    }

    private void deleteSeriesMenu() {
        System.out.print("Enter the series ID to delete: ");
        String id = scanner.nextLine();

        SeriesModel s = findSeriesById(id);
        if (s != null) {
            System.out.print("Are you sure you want to delete series " + id + "? (Y/N): ");
            String confirm = scanner.nextLine();
            if (confirm.equalsIgnoreCase("Y")) {
                deleteSeries(id);
                System.out.println("Series deleted successfully!");
            } else {
                System.out.println("Deletion cancelled.");
            }
        } else {
            System.out.println("Series with ID " + id + " not found.");
        }
    }

    private void printReportMenu() {
        if (seriesCount == 0) {
            System.out.println("No series found.");
            return;
        }
        for (int i = 0; i < seriesCount; i++) {
            System.out.println("\nSeries " + (i + 1));
            System.out.println("-----------------------------------");
            System.out.println(seriesList[i]);
        }
    }

    // PUBLIC PROGRAMMATIC METHODS (FOR TESTING) 
    public void addSeries(SeriesModel s) {
        if (seriesCount < seriesList.length) {
            seriesList[seriesCount] = s;
            seriesCount++;
        }
    }

    public SeriesModel findSeriesById(String id) {
        for (int i = 0; i < seriesCount; i++) {
            if (seriesList[i].getSeriesID().equals(id)) {
                return seriesList[i];
            }
        }
        return null;
    }

    public boolean updateSeries(String id, String newName, String newAge, String newEpisodes) {
        SeriesModel s = findSeriesById(id);
        if (s != null) {
            s.setSeriesName(newName);
            s.setSeriesAge(newAge);
            s.setSeriesNumberOfEpisodes(newEpisodes);
            return true;
        }
        return false;
    }

    public boolean deleteSeries(String id) {
        for (int i = 0; i < seriesCount; i++) {
            if (seriesList[i].getSeriesID().equals(id)) {
                for (int j = i; j < seriesCount - 1; j++) {
                    seriesList[j] = seriesList[j + 1];
                }
                seriesCount--;
                return true;
            }
        }
        return false;
    }

    //create Series object and run the menu
    public static void main(String[] args) {
        Series app = new Series();
        app.run();
    }
}
