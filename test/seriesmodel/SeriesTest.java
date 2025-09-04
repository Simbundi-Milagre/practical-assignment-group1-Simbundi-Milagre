package seriesmodel;

import org.junit.Test;
import org.junit.Assert;

public class SeriesTest {

    @Test
    public void TestSearchSeries() {
        Series series = new Series();
        SeriesModel s1 = new SeriesModel("+01", "Cinderela", "16", "10");
        series.addSeries(s1);

        SeriesModel found = series.findSeriesById("+01");

        String expectedName = "Cinderela";
        String resultName = found.getSeriesName();
        Assert.assertEquals(expectedName, resultName);
    }

    @Test
    public void TestSearchSeries_SeriesNotFound() {
        Series series = new Series();

        SeriesModel found = series.findSeriesById("+01");
        boolean expected = false;
        boolean result = (found != null);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void TestUpdateSeries() {
        Series series = new Series();
        SeriesModel s1 = new SeriesModel("+01", "Game of Bugs", "18", "12");
        series.addSeries(s1);

        boolean expected = true;
        boolean result = series.updateSeries("+01", "Game of Codes", "18", "15");
        Assert.assertEquals(expected, result);

        String expectedName = "Game of Codes";
        String resultName = series.findSeriesById("+01").getSeriesName();
        Assert.assertEquals(expectedName, resultName);
    }

    @Test
    public void TestDeleteSeries() {
        Series series = new Series();
        SeriesModel s1 = new SeriesModel("+01", "Cinderela", "16", "10");
        series.addSeries(s1);

        boolean expected = true;
        boolean result = series.deleteSeries("+01");
        Assert.assertEquals(expected, result);

        boolean expectedNotFound = false;
        boolean resultNotFound = (series.findSeriesById("+01") != null);
        Assert.assertEquals(expectedNotFound, resultNotFound);
    }

    @Test
    public void TestDeleteSeries_SeriesNotFound() {
        Series series = new Series();

        boolean expected = false;
        boolean result = series.deleteSeries("+01");
        Assert.assertEquals(expected, result);
    }

    @Test
    public void TestSeriesAgeRestriction_AgeValid() {
        SeriesModel valid = new SeriesModel("+01", "Kids Show", "10", "5");

        boolean expected = true;
        boolean result = valid.checkSeriesAge();
        Assert.assertEquals(expected, result);
    }

    @Test
    public void TestSeriesAgeRestriction_AgeInvalid() {
        SeriesModel invalid = new SeriesModel("+01", "Invalid Show", "50", "3");

        boolean expected = false;
        boolean result = invalid.checkSeriesAge();
        Assert.assertEquals(expected, result);
    }
}
