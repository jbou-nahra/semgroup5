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
   public void getReport10()

    {
        ResultSet rset = null;
        Statement stmt = null;
     // String countryCode ="";
        String countryName = "United Kingdom";
        ArrayList<City> cities = new ArrayList<>();

        System.out.printf("\nA report on All the cities in a country (%s) organized by largest population to smallest \n\n", countryName );


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

            displayReport(cities);

//            return cities;
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
    getReport11 gets a report on All the cities in a district organized by largest population to smallest.
     */
//    public ArrayList<City> getReport11()
    public void getReport11()
    {
        ResultSet rset = null;
        Statement stmt = null;
        String district = "England";

        ArrayList<City> cities = new ArrayList<>();

        System.out.printf( "\nA report on All the cities in a district (%s) organized by largest population to smallest \n\n", district );

        try
        {
            Connection con = App.getDBConnection();
            // Create an SQL statement
            stmt = con.createStatement();
            // Create string for SQL statement

            String strSelect =
                    "SELECT ID, Name, CountryCode, District, Population"
                            + " FROM city "
                            + " WHERE District = '" + district + "'"
                            + " ORDER BY population DESC ";

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
                cities.add(city);
            }


            displayReport(cities);

//            return cities;
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
   getReport12  a report on The Top N populated cities in the world where N is provided by the user
    */
    public void getReport12()//public ArrayList<City> getReport12(int n)
    {
        ResultSet rset = null;
        Statement stmt = null;

        int n = 10;

     // n = Integer.parseInt( System.console().readLine("Please Enter N: ") );
        System.out.printf("\nA report on The Top N (%s) populated cities in the world where N is provided by the user \n\n", n);

        ArrayList<City> cities = new ArrayList<>();

        try
        {
            Connection con = App.getDBConnection();
            // Create an SQL statement
            stmt = con.createStatement();
            // Create string for SQL statement

            String strSelect =
                    "SELECT ID, Name, CountryCode, District, Population"
                            + " FROM city "
                            + " ORDER BY population DESC "
                            + " Limit " + n;

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
                cities.add(city);
            }
 //           else
 //               return null;

            displayReport( cities);
//            return cities;
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

    public void getReport13()
    {
        ResultSet rset = null;
        Statement stmt = null;

        int n = 10;
        String continent = "Africa";

     // continent = System.console().readLine("Please Enter Continent: ");

        System.out.printf("\nA report on The Top N (%s) populated cities in the continent (%s) where N is provided by the user \n\n",n,continent);

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


            displayReport(cities);

//            return cities;
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
      Displays a report on All the cities in a district organized by largest population to smallest
     */
    public void displayReport(ArrayList<City> cities)
    {

        System.out.printf("%-30s %-30s %-30s %-30s%n", "City Name", "Country Name", " District", "Population");
        System.out.printf("%-30s %-30s %-30s %-30s%n"  , "=========", "============", " ========", "==========");


        for (City city : cities)
            {
                try
                {
                    System.out.printf("%-30s %-30s %-30s %-30s%n",
                            city.city_name, city.country_name, city.district, city.population);
                }catch (Exception e)
                {
                    System.out.println(e.getMessage());
                }


            }
        }


    }


