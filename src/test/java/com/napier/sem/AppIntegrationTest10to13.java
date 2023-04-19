package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AppIntegrationTest10to13
{
    static App app;
    Report10To13 report10To13 = new Report10To13();

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);
    }

    @Test
    void getReport10function()
    {
        String country = "United Kingdom";
        report10To13.getReport10("country");
    }

    @Test
    void getReport11function()
    {
       String district = "England";
       report10To13.getReport11(district);
    }

    @Test
    void getReport11null()
    {
        Report1To5 report1to5 = new Report1To5();
        report10To13.getReport11(null);
    }

    @Test
    void getReport11gibberish()
    {
        String continent = "gibberish";
        report10To13.getReport11(continent);

    }

    @Test
    void getReport12function()
    {
        String region = "Western Europe";
        report10To13.getReport12(1);
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
    void getReport4function()
    {
        Report1To5 report1to5 = new Report1To5();
        report1to5.getReport4(1);
    }

    @Test
    void getReport4int0()
    {
        Report1To5 report1to5 = new Report1To5();
        report1to5.getReport4(0);
    }

    @Test
    void getReport5function()
    {
        String continent = "Europe";
        Report1To5 report1to5 = new Report1To5();
        report1to5.getReport5(continent,10);
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

}