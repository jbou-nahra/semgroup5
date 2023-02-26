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

    public void getAllcities()
    {
        String reportDes = String.format("Jerome's report");
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
            City.printReport(cities, reportDes);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get cities details");

        }
    }


}