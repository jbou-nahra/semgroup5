package com.napier.sem;
//y
import java.awt.*;
import java.util.ArrayList;

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

/**
 Displays a report on All the cities in a district organized by largest population to smallest
 @param cities A list of cities
 @param reportDes A description of the report being printed e.g A list of cities in a country organized by population from largest to smallest
 */

    static public void printReport(ArrayList<City> cities, String reportDes)
    {

        System.out.printf ( "\u001B[32m %n%s%n%n", reportDes);
        System.out.printf("\u001B[34m%-30s %-30s %-30s %-30s%n", "City Name", "Country Name", " District", "Population");
        System.out.printf("\u001B[37m%-30s %-30s %-30s %-30s%n", "=========", "============", " ========", "==========");

        for (City city : cities)
        {
            System.out.printf("%-30s %-30s %-30s %-30s%n",
                    city.city_name, city.country_name, city.district, city.population);

        }
    }

    public void printReport(ArrayList<City> cities)
    {

        System.out.printf("%n%n%-30s %-30s %-30s %-30s", "City Name", "Country Name", " District", "Population");
        System.out.printf("%n%-30s %-30s %-30s %-30s%n", "=========", "============", " ========", "==========");

        for (City city : cities)
        {
            System.out.printf("%-30s %-30s %-30s %-30s%n",
                    city.city_name, city.country_name, city.district, city.population);

        }
    }

    static public void printcapitalcity(ArrayList<City> cities, String reportDes)
    {

        System.out.printf ( "\u001B[32m %n%s%n%n", reportDes);
        System.out.printf("\u001B[34m%-30s %-30s %-30s %n", "City Name", "Country Name", "Population");
        System.out.printf("\u001B[37m%-30s %-30s %-30s %n", "=========", "============", "==========");

        for (City city : cities)
        {
            System.out.printf("%-30s %-30s %-30s %n",
                    city.city_name, city.country_name, city.population);

        }
    }


}
