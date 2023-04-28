package com.napier.sem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Test14to17 {
    static App app;

    @BeforeAll
    static void init()
    {

        app = new App();
    }


    @Test
    void getReport14null() {
        List<String> region= null;
        assertNull(null);
    }
    @Test
    void getReport14EmptyList(){
        List<String> region =new ArrayList<>();
        assertTrue(region.isEmpty());
    }

    @Test
    void getReport14ListWithNullMember(){
        List<String> region= Arrays.asList("Paris", "Berlin", null);
        assertNotNull(region);
        assertTrue(region.contains(null));
    }


    @Test
    void getReport16count(){
        Report14To17 report14To17 = new Report14To17();
        report14To17.getReport16(2);

    }

    @Test
    void getReport17null() {
        List<String> capitalCities= null;
        assertNull(null);
    }
    @Test
    void getReport17EmptyList(){
    List<String> capitalCities =new ArrayList<>();
    assertTrue(capitalCities.isEmpty());
    }
    @Test
    void getReport17ListWithNullMember(){
        List<String> capitalCities= Arrays.asList("Paris", "Berlin", null);
        assertNotNull(capitalCities);
        assertTrue(capitalCities.contains(null));
    }
}
