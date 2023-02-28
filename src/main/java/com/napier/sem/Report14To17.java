package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Report14To17
{
    private Connection con;

    Report14To17()
    {
        try
        {
            con = App.getDBConnection();

        }catch (Exception e)
        {
            System.out.println( e.getMessage());
        }

    }

    public void getReport14()
    {
        ResultSet rset = null;
        Statement stmt = null;
        int n = 10;
        String region = "Western Europe";

        String reportDes = String.format("A report on the top N (%s) populated cities in a region (%s) where N is provided by user.",n,region);
        try
        {
            // Create an SQL statement
            stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT ID, city.Name, country.Name, CountryCode, region, city.Population,city.district"
                            + " FROM city "
                            + "INNER JOIN country on city.CountryCode = country.code"
                            + " WHERE country.region = '" + region + "'"
                            + " ORDER BY city.population DESC "
                            + "Limit " + n;
            // Execute SQL statement
            rset = stmt.executeQuery(strSelect);
            // Extract employee information
            ArrayList<City> cities = new ArrayList<>();
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
            System.out.println("Failed to get country details");
        }
        finally
        {
            try { if (rset != null) rset.close(); } catch (Exception e) {System.out.println(e.getMessage());}
            try { if (stmt != null) stmt.close(); } catch (Exception e) {System.out.println(e.getMessage());}


        }

    }


}
