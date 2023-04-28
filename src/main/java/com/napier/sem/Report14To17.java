package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Report14To17 {
    private Connection con;

    Report14To17() {
        try {
            con = App.getDBConnection();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void getReport14() {
        ResultSet rset = null;
        Statement stmt = null;
        int n = 10;
        String region = "Western Europe";

        String reportDes = String.format("A report on the top N (%s) populated cities in a region (%s) where N is provided by user.", n, region);
        try {
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

            City.printReport(cities, reportDes);

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

    public void getReport15() {
        ResultSet rset = null;
        Statement stmt = null;
        int n = 10;
        String country = "India";

        String reportDes = String.format("A report on the top N (%s) populated cities in a country (%s) where N is provided by user.", n, country);
        try {
            // Create an SQL statement
            stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT ID, city.Name, country.Name, CountryCode, city.Population,District"
                            + " FROM city "
                            + "INNER JOIN country on city.CountryCode = country.code"
                            + " WHERE country.name = '" + country + "'"
                            + " ORDER BY city.population DESC "
                            + "Limit " + n;
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

            City.printReport(cities, reportDes);

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


    public void getReport16(int i) {
        ResultSet rset = null;
        Statement stmt = null;
        int n = 10;
        String district = "Bahia";

        String reportDes = String.format("A report on the top N (%s) populated cities in a district (%s) where N is provided by user.", n, district);
        try {
            // Create an SQL statement
            stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT ID, city.Name, country.Name, CountryCode, district, city.Population,city.district"
                            + " FROM city "
                            + "INNER JOIN country on city.CountryCode = country.code"
                            + " WHERE district = '" + district + "'"
                            + " ORDER BY city.population DESC "
                            + "Limit " + n;
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

            City.printReport(cities, reportDes);

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


    public void getReport17() {
        ResultSet rset = null;
        Statement stmt = null;

        String capital= " ";

        String reportDes = String.format("A report on all the capital cities in the world organized by largest population to smallest.");
        try {
            // Create an SQL statement
            stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT ID, city.Name, city.Population,CountryCode, country.Name, District"
                            + " FROM country , city "
                            + " WHERE country.Capital = city.ID"
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

            City.printReport(cities, reportDes);

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
}