package com.napier.sem;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

public class Test1to5
{
    static App app;
    @BeforeAll
    static void init()
    {
        app = new App();
    }
    //Trying to get this one in too.
    @Test
    void getReport2null()
    {
        Report1To5 report1to5 = new Report1To5();
        report1to5.getReport2(null);
    }

    @Test
    void getReport2gibberish()
    {
        String continent = "gibberish";
        Report1To5 report1to5 = new Report1To5();
        report1to5.getReport2(continent);
    }

    @Test
    void getReport3null()
    {
        Report1To5 report1to5 = new Report1To5();
        report1to5.getReport3(null);
    }

    @Test
    void getReport3gibberish()
    {
        String region = "gibberish";
        Report1To5 report1to5 = new Report1To5();
        report1to5.getReport3(region);
    }

    @Test
    void getReport4int0()
    {
        Report1To5 report1to5 = new Report1To5();
        report1to5.getReport4(0);
    }

    @Test
    void getReport5null()
    {
        Report1To5 report1to5 = new Report1To5();
        report1to5.getReport5(null,1);
    }

    @Test
    void getReport5gibberish()
    {
        String continent = "gibberish";
        Report1To5 report1to5 = new Report1To5();
        report1to5.getReport5(continent,1);
    }
    @Test
    void getReport5int0()
    {
        String continent = "Europe";
        Report1To5 report1to5 = new Report1To5();
        report1to5.getReport5(continent,0);
    }

    @Test
    void getReport18null()
    {
        Report18To21 Report18To21 = new Report18To21();
        Report18To21.getReport18(null);
    }

    @Test
    void getReport19null()
    {
        Report18To21 Report18To21 = new Report18To21();
        Report18To21.getReport19(null);
    }

    @Test
    void getReport20int0()
    {
        Report18To21 Report18To21 = new Report18To21();
        Report18To21.getReport20(0);
    }

    @Test
    void getReport21int0()
    {
        String continent = "Western Europe";
        Report22To25 report22To25 = new Report22To25();
        report22To25.getReport22(continent, 0);
    }

    @Test
    void getReportnull()
    {
        String continent = "Western Europe";
        Report22To25 report22To25 = new Report22To25();
        report22To25.getReport22(null, 1);
    }

    @Test
    void getReport22int0()
    {
        String region = "Europe";
        Report22To25 report22To25 = new Report22To25();
        report22To25.getReport22(region, 0);
    }

    @Test
    void getReport22gibberish()
    {
        String region = "gibberish";
        Report22To25 report22To25 = new Report22To25();
        report22To25.getReport22(region, 1);
    }

    @Test
    void getReport22null()
    {
        Report22To25 report22To25 = new Report22To25();
        report22To25.getReport22(null, 1);
    }

    @Test
    void getReport27null()
    {
        Report26To31 report26To31 = new Report26To31();
        report26To31.getReport27(null);
    }

    @Test
    void getReport28null()
    {
        Report26To31 report26To31 = new Report26To31();
        report26To31.getReport28(null);
    }

    @Test
    void getReport29null()
    {
        Report26To31 report26To31 = new Report26To31();
        report26To31.getReport29(null);
    }

    @Test
    void getReport30null()
    {
        Report26To31 report26To31 = new Report26To31();
        report26To31.getReport30(null);
    }

    @Test
    void getReport31null()
    {
        Report26To31 report26To31 = new Report26To31();
        report26To31.getReport31(null);
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