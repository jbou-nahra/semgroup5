package com.napier.sem;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class AppIntegrationTest6to9 {


    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);
    }



    @Test
    void db_invalid_localhost(){
        app = new App();
        app.connect("localhost:33066", 30000);
    }

    @Test
    void getReport6function()//Test if the top 3 caribbean island are displayed
    {
      int limit= 3;
      String region = "caribbean";
      Report6To9 report6To9 = new Report6To9();
      report6To9.getReport6(limit,region);

    }

    @Test
    void getReport6iflimitiszero()//Tests if zero can be pass as a valid parameter
    {
        int limit= 0;
        String region = "caribbean";
        Report6To9 report6To9 = new Report6To9();
        report6To9.getReport6(limit,region);

    }


    @Test

    void getReport6isnull()//test if region is  null
    {
        int limit= 3;
        String region = null;
        Report6To9 report6To9 = new Report6To9();
        report6To9.getReport6(limit,region);

    }

    @Test

    void getReport6isnull_and_zero()//test if region is  null
    {
        int limit= 0;
        String region = null;
        Report6To9 report6To9 = new Report6To9();
        report6To9.getReport6(limit,region);

    }

    @Test
    void getReport6invalid_region()
    {
        int limit= 3;
        String region = "Region";
        Report6To9 report6To9 = new Report6To9();
        report6To9.getReport6(limit,region);

    }

    @Test
    void getReport7()
    {
        Report6To9 report6To9 = new Report6To9();
        report6To9.getReport7();

    }

    @Test
    void getReport8function()//
    {
        String continent = "asia";
        Report6To9 report6To9 = new Report6To9();
        report6To9.getReport8(continent);

    }


    @Test
    void getReport8isnull()//
    {
        String continent = null;
        Report6To9 report6To9 = new Report6To9();
        report6To9.getReport8(continent);

    }



    @Test
    void getReport8not_a_continent()//
    {
        String continent = "continent";
        Report6To9 report6To9 = new Report6To9();
        report6To9.getReport8(continent);

    }


    @Test
    void getReport9function()
    {
       String region="Western Europe";

       Report6To9 report6To9 = new Report6To9();
       report6To9.getReport9(region);

    }
    @Test
    void getReport9isnull()
    {
        String region=null;

        Report6To9 report6To9 = new Report6To9();
        report6To9.getReport9(region);

    }


    @Test
    void getReport9region_not_valid()
    {
        String region="region";

        Report6To9 report6To9 = new Report6To9();
        report6To9.getReport9(region);

    }
}
