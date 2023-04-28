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

    ArrayList<City> executeQuery(String strSelect)
    {
        ResultSet rset = null;
        Statement stmt = null;
        ArrayList<City> cities = new ArrayList<>();

        try
        {
            if (strSelect == null)
                throw new RuntimeException("Problem with SQL statement");

            stmt = con.createStatement();
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
        }catch (Exception e)
        {
            System.out.println(e.getMessage());

        }
        finally
        {
            try { if (rset != null) rset.close(); } catch (Exception e) {System.out.println(e.getMessage());}
            try { if (stmt != null) stmt.close(); } catch (Exception e) {System.out.println(e.getMessage());}
            //     try { if (con != null) con.close(); } catch (Exception e) {};

            return cities;
        }


    }



    /*
    getReport10 gets a report on All the cities in a country organized by largest population to smallest.
     */
    //public ArrayList<City> getReport10()
    public ArrayList<City> getReport10(String countryName)

    {

        // String countryCode ="";
        //String countryName = "United Kingdom";
        ArrayList<City> cities = new ArrayList<>();

        String reportDes = String.format("A report on All the cities in a country (%s) organized by largest population to smallest",countryName );

        if( countryName == null )
            return cities;

            // Create string for SQL statement

            String strSelect =
                    "SELECT ID, city.Name, country.Name, CountryCode, District, city.Population"
                            + " FROM city "
                            + " INNER JOIN country"
                            + " ON city.CountryCode = country.Code"
                            + " WHERE country.Name = '" + countryName + "'"
                            + " ORDER BY city.population DESC ";

            // Execute SQL statement
          cities = executeQuery( strSelect);
          return cities;

    }

    /*
    getReport11 gets a report on All the cities in a district organized by largest population to smallest.
     */
//    public ArrayList<City> getReport11()
    public ArrayList<City> getReport11( String district) {

        //String district = "England";

        ArrayList<City> cities = new ArrayList<>();

        String reportDes = String.format("A report on All the cities in a district (%s) organized by largest population to smallest", district);


        // Create string for SQL statement

        String strSelect =
                "SELECT ID, city.Name, country.Name, CountryCode, District, city.Population"
                        + " FROM city "
                        + "INNER JOIN country on city.CountryCode = country.code"
                        + " WHERE District = '" + district + "'"
                        + " ORDER BY city.population DESC ";


        cities = executeQuery(strSelect);
        return cities;
    }
    /*
   getReport12  a report on The Top N populated cities in the world where N is provided by the user
    */
    public ArrayList<City> getReport12(int n)//public ArrayList<City> getReport12(int n)
    {

        //int n = 10;

        // n = Integer.parseInt( System.console().readLine("Please Enter N: ") );
        //       System.out.printf("\nA report on The Top N (%s) populated cities in the world where N is provided by the user \n\n", n);
        String reportDes =  String.format("A report on The Top N (%s) populated cities in the world where N is provided by the user",n);

        ArrayList<City> cities = new ArrayList<>();


            String strSelect =
                    "SELECT ID, city.Name, country.Name, CountryCode, District, city.Population"
                            + " FROM city "
                            + " INNER JOIN country on city.CountryCode = country.Code"
                            + " ORDER BY city.population DESC "
                            + " Limit " + n;

        cities = executeQuery( strSelect);
        return cities;
    }

    /*
  get a report on The Top N populated cities in the continent where N is provided by the user
 */

    public ArrayList<City> getReport13(int n, String continent)
    {

        // int n = 10;
        // String continent = "Africa";

        String reportDes = String.format("A report on The Top N (%s) populated cities in the continent (%s) where N is provided by the user",n,continent);

        ArrayList<City> cities = new ArrayList<>();

            String strSelect =
                    "SELECT ID, city.Name, country.Name, CountryCode, District, city.Population"
                            + " FROM city "
                            + " INNER JOIN country on CountryCode = Code"
                            + " WHERE continent = '" + continent + "'"
                            + " ORDER BY city.population DESC "
                            + " Limit " + n;

        cities = executeQuery( strSelect);
        return cities;
    }



}


