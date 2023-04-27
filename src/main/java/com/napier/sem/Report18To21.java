package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
//Just making a change to test something.
public class Report18To21 {

    private Connection con;

    Report18To21()
    {
        try
        {
            con = App.getDBConnection();

        }catch (Exception e)
        {
            System.out.println( e.getMessage());
        }
    }

    public void getReport18(String continent) {
        ResultSet rset = null;
        Statement stmt = null;

        String reportDes = String.format("A report on all the capital cities in a continent (%s) organized by largest population to smallest.",continent);
        try {
            // Create an SQL statement
            stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT ID, city.Name, city.Population,CountryCode, country.Name, District"
                            + " FROM country , city "
                            + " WHERE country.Capital = city.ID"
                            + " AND country.continent ='" + continent + "' "
                            + " ORDER BY city.population DESC ";

            // Execute SQL statement
            rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                City city = new City();
                city.city_id = rset.getInt("ID");
                city.city_name = rset.getString("Name");
                city.country_code = rset.getString("CountryCode");
                city.district = rset.getString("District");
                city.population = rset.getInt("Population");
                city.country_name = rset.getString("country.Name");
                cities.add(city);
            }

            City.printcapitalcity(cities, reportDes);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
        } finally {
            try {
                if (rset != null) rset.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            try {
                if (stmt != null) stmt.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void getReport19(String region) {
        ResultSet rset = null;
        Statement stmt = null;


        String reportDes = String.format("A report on all the capital cities in a region (%s) organized by largest population to smallest.", region);
        try {

            if(region == null)
            {
                throw new RuntimeException("Report 19 Exception - Region Input is NULL");
            }

            // Create an SQL statement
            stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT ID, city.Name, city.Population,CountryCode, country.Name, District"
                            + " FROM country , city "
                            + " WHERE country.Capital = city.ID"
                            + " AND country.region ='" + region + "' "
                            + " ORDER BY city.population DESC ";

            // Execute SQL statement
            rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<City> cities = new ArrayList<>();
            while (rset.next()) {
                City city = new City();
                city.city_id = rset.getInt("ID");
                city.city_name = rset.getString("Name");
                city.country_code = rset.getString("CountryCode");
                city.district = rset.getString("District");
                city.population = rset.getInt("Population");
                city.country_name = rset.getString("country.Name");
                cities.add(city);
            }

            City.printcapitalcity(cities, reportDes);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
        } finally {
            try {
                if (rset != null) rset.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            try {
                if (stmt != null) stmt.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void getReport20(int n)
    {
        ResultSet rset = null;
        Statement stmt = null;

        String reportDes =  String.format("A report on The Top N (%s) populated capital cities in the world where N is provided by the user",n);

        try
        {
            if(n == 0)
            {
                throw new RuntimeException("Report 19 Exception - Input cannot be 0");
            }

            Connection con = App.getDBConnection();
            // Create an SQL statement
            stmt = con.createStatement();
            // Create string for SQL statement

            String strSelect =
                    "SELECT ID, city.Name, country.Name, CountryCode, District, city.Population"
                            + " FROM city "
                            + " INNER JOIN country on city.id = country.capital"
                            + " ORDER BY city.population DESC "
                            + " Limit " + n;

            // Execute SQL statement
            rset = stmt.executeQuery(strSelect);

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
            City.printcapitalcity(cities, reportDes);

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

    public void getReport21(String continent, int n)
    {
        ResultSet rset = null;
        Statement stmt = null;

        String reportDes =  String.format("A report on The Top N (%s) populated capital cities in a continent where N is provided by the user",n);


        try
        {
            if(continent == null)
            {
                throw new RuntimeException("Report 22 Exception - Region Input is NULL");
            }

            if(n == 0)
            {
                throw new RuntimeException("Report 22 Exception - Input cannot be 0");
            }

            Connection con = App.getDBConnection();
            // Create an SQL statement
            stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT ID, city.Name, country.Name, CountryCode, District, city.Population"
                            + " FROM city "
                            + " INNER JOIN country on city.id = country.capital"
                            + " AND country.continent ='" + continent + "' "
                            + " ORDER BY city.population DESC "
                            + " Limit " + n;

            // Execute SQL statement
            rset = stmt.executeQuery(strSelect);

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
            City.printcapitalcity(cities, reportDes);

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