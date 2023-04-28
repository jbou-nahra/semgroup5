package com.napier.sem;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

public class Test10to13
{
    static App app;
    @BeforeAll
    static void init()
    {
        app = new App();
    }




    @Test
    void printReport10To13TestNullexecuteQuery()
    {
        Report10To13 report10To13 = new Report10To13();
        report10To13.executeQuery(null);

    }
    @Test
     void printReport10TestNull()
    {
        Report10To13 report10 = new Report10To13();
        report10.getReport10(null);

    }

    @Test
    void printReport10TestNotNull()
    {
        Report10To13 report10 = new Report10To13();
        report10.getReport10("Germany");

    }

    @Test
    void printReport11TestNull()
    {
        Report10To13 report11 = new Report10To13();
        report11.getReport11(null);

    }

    @Test
    void printReport11TestNotNull()
    {
        Report10To13 report11 = new Report10To13();
        report11.getReport11("England");

    }

    @Test
    void printReport12TestZero()
    {
        Report10To13 report12 = new Report10To13();
        report12.getReport12(0);

    }

    @Test
    void printReport12TestNotZero()
    {
        Report10To13 report12 = new Report10To13();
        report12.getReport12(10);

    }

    @Test
    void printReport13TestZeroNull()
    {
        Report10To13 report13 = new Report10To13();
        report13.getReport13(0, null);

    }

    @Test
    void printReport13TestNotZeroNotNull()
    {
        Report10To13 report13 = new Report10To13();
        report13.getReport13(0, "Africa");

    }

    @Test
    void printCitiesTestNull()
    {
        City.printReport(null, "City is null");

    }


    @Test
    void printCitiesTestEmpty()
    {
        ArrayList<City> cities = new ArrayList<>();
        City.printReport(cities, "cities empty");
    }

    @Test
    void printCitiesTestContainsNull()
    {
        ArrayList<City> cities = new ArrayList<>();
        cities.add(null);
        City.printReport(cities,"Cities contain null");
    }

    @Test
    void printCities()
    {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City();
        city.city_id = 1;
        city.city_name = "Kabul";
        city.country_code = "AFG";
        city.district = "Kobol";
        city.population = 178000;
        city.country_name = "Afghanistan";

        cities.add(city);

        City.printReport(cities, "Report about Kabul");

    }

}
