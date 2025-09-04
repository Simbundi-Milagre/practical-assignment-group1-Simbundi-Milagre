/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package seriesmodel;

/**
 *
 * @author simbu
 */

public class SeriesModel {
    private String seriesID;
    private String seriesName;
    private String seriesAge;
    private String seriesNumberOfEpisodes;

    // Constructor for easy object creation in tests
    public SeriesModel(String seriesID, String seriesName, String seriesAge, String seriesNumberOfEpisodes) {
        this.seriesID = seriesID;
        this.seriesName = seriesName;
        this.seriesAge = seriesAge;
        this.seriesNumberOfEpisodes = seriesNumberOfEpisodes;
    }

    // Default constructor 
    public SeriesModel() {}

    // Getters and Setters
    public String getSeriesID() { 
        return seriesID; 
    }
    
    public void setSeriesID(String seriesID) {
        this.seriesID = seriesID; 
    }

    public String getSeriesName() {
        return seriesName; 
    }
    
    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public String getSeriesAge() {
        return seriesAge;
    }
    
    public void setSeriesAge(String seriesAge) {
        this.seriesAge = seriesAge; 
    }

    public String getSeriesNumberOfEpisodes() {
        return seriesNumberOfEpisodes;
    }
    
    public void setSeriesNumberOfEpisodes(String seriesNumberOfEpisodes) { 
        this.seriesNumberOfEpisodes = seriesNumberOfEpisodes; 
    }

    // Validate age restriction (2–18)
    public boolean checkSeriesAge() {
        if (seriesAge != null) {
            for (int i = 0; i < seriesAge.length(); i++) {
                if (!Character.isDigit(seriesAge.charAt(i))) {
                    return false;
                }
            }
            int age = Integer.parseInt(seriesAge);
            return age >= 2 && age <= 18;
        }
        return false;
    }

    @Override
    public String toString() {
        return "SERIES ID: " + seriesID +
               "\nSERIES NAME: " + seriesName +
               "\nSERIES AGE RESTRICTION: " + seriesAge +
               "\nNUMBER OF EPISODES: " + seriesNumberOfEpisodes;
    }
}
