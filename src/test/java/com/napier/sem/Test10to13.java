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
     void printCitiesTestNull()
    {
        City.printReport(null);
    }

    @Test
    void printCitiesTestEmpty()
    {
        ArrayList<City> cities = new ArrayList<>();
        City.printReport(cities);
    }

    @Test
    void printCitiesTestContainsNull()
    {
        ArrayList<City> cities = new ArrayList<>();
        cities.add(null);
        City.printReport(cities);
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

        City.printReport(cities);

    }

}
