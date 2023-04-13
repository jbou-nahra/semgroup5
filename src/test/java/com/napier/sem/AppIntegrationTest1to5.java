package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AppIntegrationTest1to5
{
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);
    }

    @Test
    void getReport1function()
    {
        Report1To5 report1to5 = new Report1To5();
        report1to5.getReport1();
    }

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
        report1to5.getReport5(null,5);
    }

    @Test
    void getReport5int0()
    {
        String continent = "Europe";
        Report1To5 report1to5 = new Report1To5();
        report1to5.getReport5(continent,0);
    }

    @Test
    void getReport5gibberish()
    {
        String continent = "gibberish";
        Report1To5 report1to5 = new Report1To5();
        report1to5.getReport5(continent,5);
    }
}