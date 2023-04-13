package com.napier.sem;

import java.sql.*;
import java.util.*;

public class Report1To5 {

    private Connection con;

    Report1To5()
    {
        try
        {
            con = App.getDBConnection();

        }catch (Exception e)
        {
            System.out.println( e.getMessage());
        }

    }

    public int getReport1()
    {

        ResultSet rset = null;
        Statement stmt = null;
        ArrayList<Country> countries = new ArrayList<>();

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

        return 0;
    }

    public void getReport2(String continent)
    {
        ResultSet rset = null;
        Statement stmt = null;

        String reportDes = String.format("A report on All the countries in a continent (%s) organised by largest population to smallest.", continent);


        try
        {
            if(continent == null)
            {
                throw new RuntimeException("Report 2 Exception - Continent Input is NULL");
            }
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
            if(rset.next()==false)
            {
                throw new RuntimeException("Report 2 Exception - no continent matches input");
            }

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
        }

        finally
        {
            try { if (rset != null) rset.close(); } catch (Exception e) {System.out.println(e.getMessage());}
            try { if (stmt != null) stmt.close(); } catch (Exception e) {System.out.println(e.getMessage());}
        }

    }

    public void getReport3(String region)
    {

        ResultSet rset = null;
        Statement stmt = null;

        String reportDes = String.format("A report on All the countries in a region (%s) organised by largest population to smallest.", region);

        try
        {
            if(region == null)
            {
                throw new RuntimeException("Report 3 Exception - Region Input is NULL");
            }
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

            if(rset.next()==false)
            {
                throw new RuntimeException("Report 3 Exception - no continent matches input");
            }
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
        }

        finally
        {
            try { if (rset != null) rset.close(); } catch (Exception e) {System.out.println(e.getMessage());}
            try { if (stmt != null) stmt.close(); } catch (Exception e) {System.out.println(e.getMessage());}
        }

    }

    public void getReport4(int n)
    {
        ResultSet rset = null;
        Statement stmt = null;

        String reportDes =  String.format("A report on The Top N (%s) populated countries in the world where N is provided by the user",n);

        try
        {
            if(n == 0)
            {
                throw new RuntimeException("Report 4 Exception - Input cannot be 0");
            }

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
        }

        finally
        {
            try { if (rset != null) rset.close(); } catch (Exception e) {System.out.println(e.getMessage());}
            try { if (stmt != null) stmt.close(); } catch (Exception e) {System.out.println(e.getMessage());}
        }

    }

    public void getReport5(String continent, int n)
    {

        ResultSet rset = null;
        Statement stmt = null;

        String reportDes =  String.format("A report on The Top N (%s) populated countries in a continent (%s) where N is provided by the user",n,continent);

        try
        {
            if(continent == null)
            {
                throw new RuntimeException("Report 5 Exception - Continent Input is NULL");
            }

            if(n == 0)
            {
                throw new RuntimeException("Report 5 Exception - Input cannot be 0");
            }
            n = n+1;
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

            if(rset.next()==false)
            {
                throw new RuntimeException("Report 5 Exception - no continent matches input");
            }

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
        }

        finally
        {
            try { if (rset != null) rset.close(); } catch (Exception e) {System.out.println(e.getMessage());}
            try { if (stmt != null) stmt.close(); } catch (Exception e) {System.out.println(e.getMessage());}
        }

    }


}