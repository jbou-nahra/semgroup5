package com.napier.sem;

import org.junit.jupiter.api.*;

public class Test1to5
{
    static App app;
    @BeforeAll
    static void init()
    {
        app = new App();
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
}
