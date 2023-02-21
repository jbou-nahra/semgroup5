package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

public class App
{
    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect()
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + i);
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

    public static void main(String[] args)
    {
        // Create new Application
        App a = new App();

        // Connect to database
        a.connect();

        // Extract cities information
        ArrayList<City> cities = a.getAllcities();
        // Extract Country information
        ArrayList<Country> countries = a.getAllCountries();

        //display  cities information
        a.printCities(cities);

        //display countries information
        a.printCountries(countries);

        // Disconnect from database
        a.disconnect();


    }

    public ArrayList<City> getAllcities()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT city.name, country.name, city.district, city.population  "
                            + "FROM city, country "
                            + "WHERE  city.CountryCode = country.code   "
                            + "ORDER BY population DESC ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
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
            return cities ;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities details");
            return null;
        }
    }

    public ArrayList<Country> getAllCountries()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Name, country.Population, country.Code, country.Continent, country.Region, city.Name "
                            +"FROM country, city "
                            +"WHERE country.Capital = city.ID "
                            +"ORDER BY Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
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
            return countries;

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }



    public void printCities(ArrayList<City> cities)
    {
        // Print header
        System.out.printf("%-30s %-30s %-30s %-30s%n", "City name", "Country name", " district", "population");

        for (City city : cities)
        {
            String city_string =
                    String.format("%-30s %-30s %-30s %-30s",
                            city.city_name, city.country_name, city.district,city.population);
            System.out.println(city_string);
        }
    }

    public void printCountries(ArrayList<Country> countries)
    {
        System.out.printf("%-5s %-40s %-20s %-30s %-15s %-20s%n", "Code", "Country", "Continent", "Region", "Population", "Capital");

        for (Country place : countries)
        {
            String place_string =
                    String.format("%-5s %-40s %-20s %-30s %-15s %-20s",place.country_code, place.country_name, place.continent_name, place.region_name, place.population, place.capitalstring);
            System.out.println(place_string);
        }
    }


}