package com.napier.sem;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class Test1to5
{
    static App app;
    @BeforeAll
    static void init()
    {
        app = new App();
    }


    @Test
    void Report1TestNull()
    {
        Report1To5 report1to5 = new Report1To5();
        assertNotNull(report1to5.getReport1());
    }
}
