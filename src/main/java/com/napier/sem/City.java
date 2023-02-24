package com.napier.sem;


import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Represents Cities in the world
 * */
public class City {

    /**
     * city's id number primary key
     * */
    public int city_id;
    /**
     * City's name
     * */
    public String city_name;

    /**
     * Country name
     * */
    public String country_name;


    /**
     * Abbreviated country names
     * */
    public String country_code;
    /**
     * City's districts
     * */
    public String district;

    /**
     * City's population
     * */
    public int population;

}
