package com.napier.sem;

import java.util.ArrayList;

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


    /**
     Displays a report on All the cities in a district organized by largest population to smallest
     @param countries A list of cities
     @param reportDes A description of the report being printed e.g A list of cities in a country organized by population from largest to smallest
     */

    public void printCountries(ArrayList<Country> countries, String reportDes)
    {
        System.out.printf ( "%n", reportDes);
        System.out.printf("%n%n%-5s %-40s %-20s %-30s %-15s %-20s%n", "Code", "Country", "Continent", "Region", "Population", "Capital");
        System.out.printf("%n%-5s %-40s %-20s %-30s %-15s %-20s%n", "====", "=======", "=========", "======", "==========", "=======");


        for (Country country : countries)
        {
            String.format("%-5s %-40s %-20s %-30s %-15s %-20s",country.country_code, country.country_name, country.continent_name, country.region_name, country.population, country.capitalstring);

        }
    }

    public void printCountries(ArrayList<Country> countries)
    {

        System.out.printf("%n%n%-5s %-40s %-20s %-30s %-15s %-20s%n", "Code", "Country", "Continent", "Region", "Population", "Capital");
        System.out.printf("%n%-5s %-40s %-20s %-30s %-15s %-20s%n", "====", "=======", "=========", "======", "==========", "=======");


        for (Country country : countries)
        {
            String.format("%-5s %-40s %-20s %-30s %-15s %-20s",country.country_code, country.country_name, country.continent_name, country.region_name, country.population, country.capitalstring);

        }
    }

}
