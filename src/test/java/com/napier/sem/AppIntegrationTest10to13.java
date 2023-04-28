package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class AppIntegrationTest10to13
{
    static App app;
    static Report10To13 report10To13;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);
        report10To13 = new Report10To13();
    }

    @Test
    void testDBConnection()
    {

    }

    @Test
    void testGetReport10()
    {
        ArrayList<City> cities = report10To13.getReport10("United Kingdom");
       // assertEquals(81, cities.size());//the number of records returned
        assertEquals("London", cities.get(0).city_name);
        assertEquals("England", cities.get(0).district);
        assertEquals(7285000, cities.get(0).population);
    }

    @Test
     void testGetReport10To13TestexecuteQuery()
    {
        String countryName = "United Kingdom";

        String strSelect =
                "SELECT ID, city.Name, country.Name, CountryCode, District, city.Population"
                        + " FROM city "
                        + " INNER JOIN country"
                        + " ON city.CountryCode = country.Code"
                        + " WHERE country.Name = '" + countryName + "'"
                        + " ORDER BY city.population DESC ";

        report10To13.executeQuery(strSelect);

    }

    @Test
    void testGetReport10To13TestNullexecuteQuery()
    {
        String countryName = "United Kingdom";

        String strSelect = null;

        report10To13.executeQuery(strSelect);

    }

    @Test
    void testGetReport12()
    {

    }

    @Test
    void testGetReport13()
    {

    }

    @Test
    void reportlanguagesfunction()
    {
        ReportLanguages reportLanguages = new ReportLanguages();
        reportLanguages.getReportLanguages();
    }






}