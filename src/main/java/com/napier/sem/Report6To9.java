package com.napier.sem;

import java.sql.*;
import java.util.*;

public class Report6To9 {

    private Connection con;

    Report6To9()
    {
        try
        {
            con = App.getDBConnection();

        }catch (Exception e)
        {
            System.out.println( e.getMessage());
        }

    }
    public void getReport6()
    {

        ResultSet rset = null;
        Statement stmt = null;
        int limit =3;
        String reportDes = String.format("report on the top (%o) populated countries in a region in the world ",limit);
        try
        {
            // Create an SQL statement
            stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT code, name, continent, region, population, capital "
                            + "FROM  country "
                            + "WHERE  region = 'caribbean'   "
                            + "ORDER BY population DESC "
                            + "limit 3 ";
            // Execute SQL statement
            rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<Country>  countries = new ArrayList<Country>();
            while (rset.next())
            {
                Country country = new Country();
                country.country_code = rset.getString("code");
                 country.country_name= rset.getString("name");
                country.continent_name = rset.getString("continent");
                country.region_name = rset.getString("region");
                country.population = rset.getInt("population");
                country.capital = rset.getInt("capital");
                countries.add(country);
            }
            Country.printCountries(countries, reportDes);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities details");

        }
    }

   public void getReport7()
    {

        ResultSet rset = null;
        Statement stmt = null;
        String reportDes = String.format("report on All the cities in the world organised by population from the largest to the smallest ");
        try
        {
            // Create an SQL statement
             stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.name, country.name, city.district, city.population  "
                            + "FROM city, country "
                            + "WHERE  city.CountryCode = country.code   "
                            + "ORDER BY population DESC ";
            // Execute SQL statement
            rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                City city = new City();
                city.city_name = rset.getString("city.name");
                city.country_name = rset.getString("country.name");
                city.district = rset.getString("city.district");
                city.population = rset.getInt("city.population");
                cities.add(city);
            }
            City.printReport(cities, reportDes);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities details");

        }
    }



    public void getReport8()
    {

        ResultSet rset = null;
        Statement stmt = null;
        String continent = "asia";
        String reportDes = String.format("report on All the cities in a continent (%s) in the world by population from largest to smallest ",continent);
        try
        {
            // Create an SQL statement
            stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.name, country.name, city.district, city.population  "
                            + "FROM city "
                            + "JOIN country on city.countrycode = country.code  "
                            + "WHERE  country.continent='asia'"
                            + "ORDER BY population DESC";
            // Execute SQL statement
            rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                City city = new City();
                city.city_name = rset.getString("city.name");
                city.country_name = rset.getString("country.name");
                city.district = rset.getString("city.district");
                city.population = rset.getInt("city.population");
                cities.add(city);
            }
            City.printReport(cities, reportDes);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities details");

        }
    }


    public void getReport9()
    {

        ResultSet rset = null;
        Statement stmt = null;
        String region = "Southern Europe";
        String reportDes = String.format("report on All the cities in a region (%s) in the world organised by population from the largest to the smallest",region);
        try
        {
            // Create an SQL statement
            stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.name, country.name, city.district, city.population  "
                            + "FROM city "
                            + "JOIN country on city.countrycode = country.code  "
                            + "WHERE  country.region='Southern Europe'"
                            + "ORDER BY population DESC";
            // Execute SQL statement
            rset = stmt.executeQuery(strSelect);
            // Extract city information
            ArrayList<City> cities = new ArrayList<City>();
            while (rset.next())
            {
                City city = new City();
                city.city_name = rset.getString("city.name");
                city.country_name = rset.getString("country.name");
                city.district = rset.getString("city.district");
                city.population = rset.getInt("city.population");
                cities.add(city);
            }
            City.printReport(cities, reportDes);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities details");

        }
    }





}