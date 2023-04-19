package com.napier.sem;

import java.sql.*;
import java.util.*;

public class Report10To13 {

    private Connection con;

    Report10To13()
    {
        try
        {
            con = App.getDBConnection();

        }catch (Exception e)
        {
            System.out.println( e.getMessage());
        }

    }


    /*
    getReport10 gets a report on All the cities in a country organized by largest population to smallest.
     */
    //public ArrayList<City> getReport10()
    public void getReport10(String countryName)

    {
        ResultSet rset = null;
        Statement stmt = null;
        // String countryCode ="";
        //String countryName = "United Kingdom";
        ArrayList<City> cities = new ArrayList<>();

        String reportDes = String.format("A report on All the cities in a country (%s) organized by largest population to smallest",countryName );


        try
        {

            // Create an SQL statement
            stmt = con.createStatement();
            // Create string for SQL statement

            String strSelect =
                    "SELECT ID, city.Name, country.Name, CountryCode, District, city.Population"
                            + " FROM city "
                            + " INNER JOIN country"
                            + " ON city.CountryCode = country.Code"
                            + " WHERE country.Name = '" + countryName + "'"
                            + " ORDER BY city.population DESC ";

            // Execute SQL statement
            rset = stmt.executeQuery(strSelect);

            while (rset.next())
            {
                City city = new City();
                city.city_id = rset.getInt("ID");
                city.city_name = rset.getString("Name");
                city.country_code = rset.getString("CountryCode");
                city.district = rset.getString("District");
                city.population = rset.getInt("Population");
                city.country_name = rset.getString("country.Name");
                cities.add(city);
            }

            City.printReport(cities, reportDes);

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());

        }
        finally
        {
            try { if (rset != null) rset.close(); } catch (Exception e) {System.out.println(e.getMessage());}
            try { if (stmt != null) stmt.close(); } catch (Exception e) {System.out.println(e.getMessage());}
            //     try { if (con != null) con.close(); } catch (Exception e) {};

        }

    }

    /*
    getReport11 gets a report on All the cities in a district organized by largest population to smallest.
     */
//    public ArrayList<City> getReport11()
    public void getReport11( String district)
    {
        ResultSet rset = null;
        Statement stmt = null;
        //String district = "England";

        ArrayList<City> cities = new ArrayList<>();

        String reportDes = String.format( "A report on All the cities in a district (%s) organized by largest population to smallest", district );

        try
        {
            Connection con = App.getDBConnection();
            // Create an SQL statement
            stmt = con.createStatement();
            // Create string for SQL statement

            String strSelect =
                    "SELECT ID, city.Name, country.Name, CountryCode, District, city.Population"
                            + " FROM city "
                            + "INNER JOIN country on city.CountryCode = country.code"
                            + " WHERE District = '" + district + "'"
                            + " ORDER BY city.population DESC ";


            // Execute SQL statement
            rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned
            while (rset.next())
            {
                City city = new City();
                city.city_id = rset.getInt("ID");
                city.city_name = rset.getString("Name");
                city.country_code = rset.getString("CountryCode");
                city.district = rset.getString("District");
                city.population = rset.getInt("Population");
                city.country_name = rset.getString("country.Name");
                cities.add(city);
            }

            City.printReport(cities, reportDes);

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());

        }
        finally
        {
            try { if (rset != null) rset.close(); } catch (Exception e) {System.out.println(e.getMessage());}
            try { if (stmt != null) stmt.close(); } catch (Exception e) {System.out.println(e.getMessage());}
            //     try { if (con != null) con.close(); } catch (Exception e) {};

        }
    }

    /*
   getReport12  a report on The Top N populated cities in the world where N is provided by the user
    */
    public void getReport12(int n)//public ArrayList<City> getReport12(int n)
    {
        ResultSet rset = null;
        Statement stmt = null;

        //int n = 10;

        // n = Integer.parseInt( System.console().readLine("Please Enter N: ") );
        //       System.out.printf("\nA report on The Top N (%s) populated cities in the world where N is provided by the user \n\n", n);
        String reportDes =  String.format("A report on The Top N (%s) populated cities in the world where N is provided by the user",n);

        ArrayList<City> cities = new ArrayList<>();

        try
        {
            Connection con = App.getDBConnection();
            // Create an SQL statement
            stmt = con.createStatement();
            // Create string for SQL statement

            String strSelect =
                    "SELECT ID, city.Name, country.Name, CountryCode, District, city.Population"
                            + " FROM city "
                            + " INNER JOIN country on city.CountryCode = country.Code"
                            + " ORDER BY city.population DESC "
                            + " Limit " + n;

            // Execute SQL statement
            rset = stmt.executeQuery(strSelect);

            while (rset.next())
            {
                City city = new City();
                city.city_id = rset.getInt("ID");
                city.city_name = rset.getString("Name");
                city.country_code = rset.getString("CountryCode");
                city.district = rset.getString("District");
                city.population = rset.getInt("Population");
                city.country_name = rset.getString("country.Name");

                cities.add(city);
            }

            City.printReport(cities, reportDes);

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");

        }
        finally
        {
            try { if (rset != null) rset.close(); } catch (Exception e) {System.out.println(e.getMessage());}
            try { if (stmt != null) stmt.close(); } catch (Exception e) {System.out.println(e.getMessage());}
            //     try { if (con != null) con.close(); } catch (Exception e) {};

        }
    }

    /*
  get a report on The Top N populated cities in the continent where N is provided by the user
 */

    public void getReport13(int n, String continent)
    {
        ResultSet rset = null;
        Statement stmt = null;

        // int n = 10;
        // String continent = "Africa";

        String reportDes = String.format("A report on The Top N (%s) populated cities in the continent (%s) where N is provided by the user",n,continent);

        ArrayList<City> cities = new ArrayList<>();

        try
        {
            Connection con = App.getDBConnection();
            // Create an SQL statement
            stmt = con.createStatement();
            // Create string for SQL statement

            String strSelect =
                    "SELECT ID, city.Name, country.Name, CountryCode, District, city.Population"
                            + " FROM city "
                            + " INNER JOIN country on CountryCode = Code"
                            + " WHERE continent = '" + continent + "'"
                            + " ORDER BY city.population DESC "
                            + " Limit " + n;

            // Execute SQL statement
            rset = stmt.executeQuery(strSelect);

            while (rset.next())
            {
                City city = new City();
                city.city_id = rset.getInt("ID");
                city.city_name = rset.getString("Name");
                city.country_code = rset.getString("CountryCode");
                city.district = rset.getString("District");
                city.population = rset.getInt("Population");
                city.country_name = rset.getString("country.Name");
                cities.add(city);
            }


            City.printReport(cities, reportDes);


        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());

        }
        finally
        {
            try { if (rset != null) rset.close(); } catch (Exception e) {System.out.println(e.getMessage());}
            try { if (stmt != null) stmt.close(); } catch (Exception e) {System.out.println(e.getMessage());}
            //     try { if (con != null) con.close(); } catch (Exception e) {};

        }
    }



}


