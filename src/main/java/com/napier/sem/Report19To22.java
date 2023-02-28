package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Report19To22 {

    private Connection con;

    Report19To22()
    {
        try
        {
            con = App.getDBConnection();

        }catch (Exception e)
        {
            System.out.println( e.getMessage());
        }

    }

    public void getReport19()
    {
        ResultSet rset = null;
        Statement stmt = null;

        String reportDes = String.format("A report on All the Countries in the World organized by largest population to smallest");
        try
        {
            // Create an SQL statement
            stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Name, country.Population, country.Code, country.Continent, country.Region, city.Name "
                            +"FROM country, city "
                            +"WHERE country.Capital = city.ID "
                            +"ORDER BY Population DESC";
            // Execute SQL statement
            rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next())
            {
                Country place = new Country();
                place.country_name = rset.getString("country.Name");
                place.population = rset.getInt("country.Population");
                place.capitalstring = rset.getString("city.Name");
                place.country_code = rset.getString("country.Code");
                place.continent_name = rset.getString("country.Continent");
                place.region_name = rset.getString("country.Region");
                countries.add(place);
            }

            Country.printCountries(countries, reportDes);

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
        }
        finally
        {
            try { if (rset != null) rset.close(); } catch (Exception e) {System.out.println(e.getMessage());}
            try { if (stmt != null) stmt.close(); } catch (Exception e) {System.out.println(e.getMessage());}


        }

    }

    public void getReport20()
    {
        ResultSet rset = null;
        Statement stmt = null;
        String continent = "Europe";

        String reportDes = String.format("A report on All the countries in a continent (%s) organised by largest population to smallest.", continent);

        try
        {
            // Create an SQL statement
            stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Name, country.Population, country.Code, country.Continent, country.Region, city.Name "
                            +"FROM country, city "
                            +"WHERE country.Capital = city.ID AND country.continent ='" + continent + "' "
                            +"ORDER BY Population DESC";
            // Execute SQL statement
            rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next())
            {
                Country place = new Country();
                place.country_name = rset.getString("country.Name");
                place.population = rset.getInt("country.Population");
                place.capitalstring = rset.getString("city.Name");
                place.country_code = rset.getString("country.Code");
                place.continent_name = rset.getString("country.Continent");
                place.region_name = rset.getString("country.Region");
                countries.add(place);
            }

            Country.printCountries(countries, reportDes);

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
        }
        finally
        {
            try { if (rset != null) rset.close(); } catch (Exception e) {System.out.println(e.getMessage());}
            try { if (stmt != null) stmt.close(); } catch (Exception e) {System.out.println(e.getMessage());}


        }

    }

    public void getReport21()
    {
        ResultSet rset = null;
        Statement stmt = null;
        String region = "Western Europe";

        String reportDes = String.format("A report on All the countries in a region (%s) organised by largest population to smallest.", region);

        try
        {
            // Create an SQL statement
            stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Name, country.Population, country.Code, country.Continent, country.Region, city.Name "
                            +"FROM country, city "
                            +"WHERE country.Capital = city.ID AND country.region ='" + region + "' "
                            +"ORDER BY Population DESC";
            // Execute SQL statement
            rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next())
            {
                Country place = new Country();
                place.country_name = rset.getString("country.Name");
                place.population = rset.getInt("country.Population");
                place.capitalstring = rset.getString("city.Name");
                place.country_code = rset.getString("country.Code");
                place.continent_name = rset.getString("country.Continent");
                place.region_name = rset.getString("country.Region");
                countries.add(place);
            }

            Country.printCountries(countries, reportDes);

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
        }
        finally
        {
            try { if (rset != null) rset.close(); } catch (Exception e) {System.out.println(e.getMessage());}
            try { if (stmt != null) stmt.close(); } catch (Exception e) {System.out.println(e.getMessage());}


        }

    }

    public void getReport22()
    {
        ResultSet rset = null;
        Statement stmt = null;

        int n = 10;

        String reportDes =  String.format("A report on The Top N (%s) populated countries in the world where N is provided by the user",n);

        ArrayList<City> cities = new ArrayList<>();

        try
        {
            Connection con = App.getDBConnection();
            // Create an SQL statement
            stmt = con.createStatement();
            // Create string for SQL statement

            String strSelect =
                    "SELECT country.Name, country.Population, country.Code, country.Continent, country.Region, city.Name "
                            +"FROM country, city "
                            +"WHERE country.Capital = city.ID "
                            +"ORDER BY Population DESC "
                            +"Limit " + n;

            // Execute SQL statement
            rset = stmt.executeQuery(strSelect);

            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next())
            {
                Country place = new Country();
                place.country_name = rset.getString("country.Name");
                place.population = rset.getInt("country.Population");
                place.capitalstring = rset.getString("city.Name");
                place.country_code = rset.getString("country.Code");
                place.continent_name = rset.getString("country.Continent");
                place.region_name = rset.getString("country.Region");
                countries.add(place);
            }

            Country.printCountries(countries, reportDes);

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");

        }
        finally
        {
            try { if (rset != null) rset.close(); } catch (Exception e) {System.out.println(e.getMessage());}
            try { if (stmt != null) stmt.close(); } catch (Exception e) {System.out.println(e.getMessage());}


        }
    }

    public void getReport23()
    {
        ResultSet rset = null;
        Statement stmt = null;

        String continent = "Europe";
        int n = 10;

        String reportDes =  String.format("A report on The Top N (%s) populated countries in a continent (%s) where N is provided by the user",n,continent);

        ArrayList<City> cities = new ArrayList<>();

        try
        {
            Connection con = App.getDBConnection();
            // Create an SQL statement
            stmt = con.createStatement();
            // Create string for SQL statement

            String strSelect =
                    "SELECT country.Name, country.Population, country.Code, country.Continent, country.Region, city.Name "
                            +"FROM country, city "
                            +"WHERE country.Capital = city.ID AND country.continent ='" + continent + "' "
                            +"ORDER BY Population DESC "
                            +"Limit " + n;

            // Execute SQL statement
            rset = stmt.executeQuery(strSelect);

            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next())
            {
                Country place = new Country();
                place.country_name = rset.getString("country.Name");
                place.population = rset.getInt("country.Population");
                place.capitalstring = rset.getString("city.Name");
                place.country_code = rset.getString("country.Code");
                place.continent_name = rset.getString("country.Continent");
                place.region_name = rset.getString("country.Region");
                countries.add(place);
            }

            Country.printCountries(countries, reportDes);

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");

        }
        finally
        {
            try { if (rset != null) rset.close(); } catch (Exception e) {System.out.println(e.getMessage());}
            try { if (stmt != null) stmt.close(); } catch (Exception e) {System.out.println(e.getMessage());}


        }
    }


}