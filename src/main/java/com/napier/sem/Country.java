package com.napier.sem;

import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Represents Countries in the world
 * */
public class Country {

    /**
     * Abbreviated country names primary key
     * */
    public String country_code;

    /**
     * Country name
     * */
    public String country_name;

    /**
     *  Continent name
     * */
    public String continent_name;

    /**
     *  Region name
     * */
    public String region_name;

    /**
     * Surface Area
     * */
    public double surface_area;


    /**
     * Independence year
     * */
    public int indep_year;


    /**
     * country's population
     * */
    public int population;

    /**
     * life Expectancy
     * */
    public double life_expectancy;


    /**
     * Gross National Product
     * */
    public double gnp;

    /**
     * old Gross National Product
     * */
    public double old_gnp;


    /**
     *  local name
     * */
    public String local_name;


    /**
     *  Government Form
     * */
    public String government_form;

    /**
     *  Head of State
     * */
    public String head_of_state;


    /**
     * capital
     * */
    public int capital;

    /**
     * member to hold capital as string
     * */
    public String capitalstring;



    /**
     * Abbreviated country names   in two letters
     * */
    public String country_code2;



}
