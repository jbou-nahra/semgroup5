package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

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
    void testGetReport10()
    {
        ArrayList<City> cities = report10To13.getReport10("United Kingdom");
        assertEquals(81, cities.size());//the number of records returned
        assertEquals("London", cities.get(0).city_name);
        assertEquals("England", cities.get(0).district);
        assertEquals(7285000, cities.get(0).population);
    }

    @Test
     void testGetReport11()
    {

    }

    @Test
    void testGetReport12()
    {

    }

    @Test
    void testGetReport13()
    {

    }





}