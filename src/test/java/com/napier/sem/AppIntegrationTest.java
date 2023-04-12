package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AppIntegrationTest
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


}