package com.napier.sem;

import java.sql.*;
import java.util.*;
public class Report26To31 {

    private Connection con;

    Report26To31()
    {
        try
        {
            con = App.getDBConnection();

        }catch (Exception e)
        {
            System.out.println( e.getMessage());
        }

    }

    public void getReport26()
    {

        ResultSet rset = null;
        Statement stmt = null;
        Long countriespop = null;


        try
        {
            // Create an SQL statement
            stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT sum(country.population) "
                            + "FROM country ";

            // Execute SQL statement
            rset = stmt.executeQuery(strSelect);
            // Extract employee information
            while (rset.next())
            {
                countriespop = rset.getLong("sum(country.population)");
            }

            System.out.printf("\u001B[32m %n%s%n%n","A Report on the population of the world.");
            System.out.printf("\u001B[34m%-20s %-20s%n", "Location", "Total Population");
            System.out.printf("\u001B[37m%-20s %-20s%n", "==============", "================");
            System.out.printf("%-20s %-20s%n", "World", countriespop);

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

    public void getReport27(String continent)
    {

        ResultSet rset = null;
        Statement stmt = null;
        Long continentpop = null;


        try
        {
            if(continent == null)
            {
                throw new RuntimeException("Report 27 Exception - Continent Input is NULL");
            }
            // Create an SQL statement
            stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT sum(country.population) "
                            + "FROM country "
                            + "WHERE country.continent ='" + continent + "' ";
            // Execute SQL statement
            rset = stmt.executeQuery(strSelect);
            // Extract employee information

            while (rset.next())
            {
                continentpop = rset.getLong("sum(country.population)");
            }

            System.out.printf("\u001B[32m %n%s%n%n","A Report on the population a continent");
            System.out.printf("\u001B[34m%-20s %-20s%n", "Continent", "Total Population");
            System.out.printf("\u001B[37m%-20s %-20s%n", "==============", "================");
            System.out.printf("%-20s %-20s%n", continent, continentpop);

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

    public void getReport28(String region)
    {

        ResultSet rset = null;
        Statement stmt = null;
        Long regionpop = null;


        try
        {
            if(region == null)
            {
                throw new RuntimeException("Report 28 Exception - Continent Input is NULL");
            }
            // Create an SQL statement
            stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT sum(country.population) "
                            + "FROM country "
                            + "WHERE country.region ='" + region + "' ";
            // Execute SQL statement
            rset = stmt.executeQuery(strSelect);
            // Extract employee information

            while (rset.next())
            {
                regionpop = rset.getLong("sum(country.population)");
            }

            System.out.printf("\u001B[32m %n%s%n%n","A Report on the population a region.");
            System.out.printf("\u001B[34m%-20s %-20s%n", "Region", "Total Population");
            System.out.printf("\u001B[37m%-20s %-20s%n", "==============", "================");
            System.out.printf("%-20s %-20s%n", region, regionpop);

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

    public void getReport29(String country)
    {

        ResultSet rset = null;
        Statement stmt = null;
        Long countriespop = null;


        try
        {
            if(country == null)
            {
                throw new RuntimeException("Report 29 Exception - Continent Input is NULL");
            }
            // Create an SQL statement
            stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.population "
                            + "FROM country "
                            + "WHERE country.name ='" + country + "' ";

            // Execute SQL statement
            rset = stmt.executeQuery(strSelect);
            // Extract employee information
            while (rset.next())
            {
                countriespop = rset.getLong("country.population");
            }

            System.out.printf("\u001B[32m %n%s%n%n","A Report on the population of a country.");
            System.out.printf("\u001B[34m%-20s %-20s%n", "Country", "Total Population");
            System.out.printf("\u001B[37m%-20s %-20s%n", "==============", "================");
            System.out.printf("%-20s %-20s%n", country, countriespop);

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

    public void getReport30(String district)
    {

        ResultSet rset = null;
        Statement stmt = null;
        Long districtpop = null;


        try
        {
            if(district == null)
            {
                throw new RuntimeException("Report 30 Exception - Continent Input is NULL");
            }
            // Create an SQL statement
            stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT sum(city.population) "
                            + "FROM city "
                            + "WHERE city.district ='" + district + "' ";

            // Execute SQL statement
            rset = stmt.executeQuery(strSelect);
            // Extract employee information
            while (rset.next())
            {
                districtpop = rset.getLong("sum(city.population)");
            }

            System.out.printf("\u001B[32m %n%s%n%n","A Report on the population of a district.");
            System.out.printf("\u001B[34m%-20s %-20s%n", "District", "Total Population");
            System.out.printf("\u001B[37m%-20s %-20s%n", "==============", "================");
            System.out.printf("%-20s %-20s%n", district, districtpop);

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

    public void getReport31(String city)
    {

        ResultSet rset = null;
        Statement stmt = null;
        Long districtpop = null;


        try
        {
            if(city == null)
            {
                throw new RuntimeException("Report 31 Exception - City Input is NULL");
            }

            // Create an SQL statement
            stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT sum(city.population) "
                            + "FROM city "
                            + "WHERE city.name ='" + city + "' ";

            // Execute SQL statement
            rset = stmt.executeQuery(strSelect);
            // Extract employee information
            while (rset.next())
            {
                districtpop = rset.getLong("sum(city.population)");
            }

            System.out.printf("\u001B[32m %n%s%n%n","A Report on the population of a city.");
            System.out.printf("\u001B[34m%-20s %-20s%n", "City", "Total Population");
            System.out.printf("\u001B[37m%-20s %-20s%n", "==============", "================");
            System.out.printf("%-20s %-20s%n", city, districtpop);

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
