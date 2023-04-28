package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppIntegrationTest14to17 {
    static App app;
    Report14To17 report14To17 = new Report14To17();

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);
    }

    @Test
    void getReport14function(){
        Report14To17 report14To17 = new Report14To17();
        report14To17.getReport14();
    }

    @Test
    void getReport15function(){
        Report14To17 report14To17 = new Report14To17();
        report14To17.getReport15();
    }

    @Test
    void getReport16function(){
        String city = "Bahia";
        Report14To17 report14To17 = new Report14To17();
        report14To17.getReport16(5);
    }

    @Test
    void getReport17function() {
        Report14To17 report14To17 = new Report14To17();
        report14To17.getReport17();
    }


}
