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
    void getReport2function()
    {
        String continent = "Europe";
        Report1To5 report1to5 = new Report1To5();
        report1to5.getReport2(continent);
    }

    @Test
    void getReport3function()
    {
        String region = "Western Europe";
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
    void getReport5function()
    {
        String continent = "Europe";
        Report1To5 report1to5 = new Report1To5();
        report1to5.getReport5(continent,1);
    }

    @Test
    void getReport19function()
    {
        Report19To22 Report19To22 = new Report19To22();
        Report19To22.getReport19(1);
    }

    @Test
    void getReport22function()
    {
        String region = "Western Europe";
        Report22To25 report22To25 = new Report22To25();
        report22To25.getReport22(region, 5);
    }

    @Test
    void getReport23function()
    {
        Report22To25 report22To25 = new Report22To25();
        report22To25.getReport23();
    }

    @Test
    void getReport24function()
    {
        Report22To25 report22To25 = new Report22To25();
        report22To25.getReport24();
    }

    @Test
    void getReport25function()
    {
        Report22To25 report22To25 = new Report22To25();
        report22To25.getReport25();
    }

    @Test
    void getReport26function()
    {
        Report26To31 report26To31 = new Report26To31();
        report26To31.getReport26();
    }

    @Test
    void getReport27function()
    {
        String continent = "Europe";
        Report26To31 report26To31 = new Report26To31();
        report26To31.getReport27(continent);
    }

    @Test
    void getReport28function()
    {
        String region = " Western Europe";
        Report26To31 report26To31 = new Report26To31();
        report26To31.getReport27(region);
    }

    @Test
    void getReport29function()
    {
        String country = "China";
        Report26To31 report26To31 = new Report26To31();
        report26To31.getReport29(country);
    }

}