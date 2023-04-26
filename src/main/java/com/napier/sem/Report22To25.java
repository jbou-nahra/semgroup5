package com.napier.sem;

import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Report22To25 {
    private Connection con;

    Report22To25()
    {
        try
        {
            con = App.getDBConnection();

        }catch (Exception e)
        {
            System.out.println( e.getMessage());
        }

    }

    public void getReport22(String region, int n)
    {
        ResultSet rset = null;
        Statement stmt = null;

        String reportDes =  String.format("A report on The Top N (%s) populated capital cities in a region where N is provided by the user",n);


        try
        {
            if(region == null)
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
                            + " AND country.region ='" + region + "' "
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

    public void getReport23()
    {

        ResultSet rset = null;
        Statement stmt = null;
        ArrayList<String> continent = new ArrayList<>();
        ArrayList<Long> countrypop = new ArrayList<>();
        ArrayList<Long> citypop = new ArrayList<>();
        ArrayList<Long> ruralpop = new ArrayList<>();

        try
        {
            stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT DISTINCT country.continent "
                            +"FROM country";
            // Execute SQL statement

            rset = stmt.executeQuery(strSelect);

            // Extract employee information




            while (rset.next())
            {
                String conlocation;
                conlocation = rset.getString("country.continent");
                continent.add(conlocation);
            }
            rset = null;
            stmt = null;

            System.out.printf("What we heare after continent grab.");

            for(int z = 0; z < continent.size() ; z++)
            {
                // Create an SQL statement
                stmt = con.createStatement();
                // Create string for SQL statement
                strSelect =
                        "SELECT sum(country.population) "
                                + "FROM country "
                                + "WHERE country.continent ='" + continent.get(z) + "' ";
                // Execute SQL statement
                rset = stmt.executeQuery(strSelect);
                // Extract employee information

                while(rset.next())
                {
                    Long conpop;
                    conpop = rset.getLong("sum(country.population)");
                    countrypop.add(conpop);
                }
            }

            rset = null;
            stmt = null;

            for(int z = 0; z < continent.size() ; z++)
            {
                // Create an SQL statement
                stmt = con.createStatement();
                // Create string for SQL statement
                strSelect =
                        "SELECT sum(city.population) "
                                + "FROM city, country "
                                + "WHERE country.continent ='" + continent.get(z) + "' "
                                + "AND country.code = city.countrycode";
                // Execute SQL statement
                rset = stmt.executeQuery(strSelect);
                // Extract employee information

                while(rset.next())
                {
                    Long citpop;
                    citpop = rset.getLong("sum(city.population)");
                    citypop.add(citpop);
                }
                long temp;
                temp = countrypop.get(z)-citypop.get(z) ;
                ruralpop.add(temp);
            }
            System.out.printf("\u001B[32m %n%s%n%n","A Report on the population of people, people living in cities, and people not living in cities in each continent.");
            System.out.printf("\u001B[34m%-20s %-20s %-20s %-20s %-20s %-20s%n", "Continent", "Total Population", "Rural Population", "Rural Percentage", "City Percentage", "City Population");
            System.out.printf("\u001B[37m%-20s %-20s %-20s %-20s %-20s %-20s%n", "==============","==============", "================", "================", "===============", "===============");

            for(int z = 0; z < continent.size() ; z++)
            {
                Long ruralpercent=null;
                Long citypercent=null;
                if(ruralpop.get(z) != 0 && citypop.get(z) != 0)
                {
                    ruralpercent = ruralpop.get(z) * 100;
                    ruralpercent = ruralpercent / countrypop.get(z);

                    citypercent = citypop.get(z) * 100;
                    citypercent = citypercent / countrypop.get(z);
                }

                System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s%n", continent.get(z), countrypop.get(z), ruralpop.get(z), ruralpercent, citypercent, citypop.get(z));
            }
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

    public void getReport24()
    {

        ResultSet rset = null;
        Statement stmt = null;
        ArrayList<String> region = new ArrayList<>();
        ArrayList<Long> countrypop = new ArrayList<>();
        ArrayList<Long> citypop = new ArrayList<>();
        ArrayList<Long> ruralpop = new ArrayList<>();

        try
        {
            stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT DISTINCT country.region "
                            +"FROM country";
            // Execute SQL statement

            rset = stmt.executeQuery(strSelect);

            // Extract employee information




            while (rset.next())
            {
                String conlocation;
                conlocation = rset.getString("country.region");
                region.add(conlocation);
            }
            rset = null;
            stmt = null;

            for(int z = 0; z < region.size() ; z++)
            {
                // Create an SQL statement
                stmt = con.createStatement();
                // Create string for SQL statement
                strSelect =
                        "SELECT sum(country.population) "
                                + "FROM country "
                                + "WHERE country.region ='" + region.get(z) + "' ";
                // Execute SQL statement
                rset = stmt.executeQuery(strSelect);
                // Extract employee information

                while(rset.next())
                {
                    Long conpop;
                    conpop = rset.getLong("sum(country.population)");
                    countrypop.add(conpop);
                }
            }

            rset = null;
            stmt = null;

            for(int z = 0; z < region.size() ; z++)
            {
                // Create an SQL statement
                stmt = con.createStatement();
                // Create string for SQL statement
                strSelect =
                        "SELECT sum(city.population) "
                                + "FROM city, country "
                                + "WHERE country.region ='" + region.get(z) + "' "
                                + "AND country.code = city.countrycode";
                // Execute SQL statement
                rset = stmt.executeQuery(strSelect);
                // Extract employee information

                while(rset.next())
                {
                    Long citpop;
                    citpop = rset.getLong("sum(city.population)");
                    citypop.add(citpop);
                }
                long temp;
                temp = countrypop.get(z)-citypop.get(z) ;
                ruralpop.add(temp);
            }
            System.out.printf("\u001B[32m %n%s%n%n","A Report on the population of people, people living in cities, and people not living in cities in each region.");
            System.out.printf("\u001B[34m%-30s %-20s %-20s %-20s %-20s %-20s%n", "Region", "Total Population", "Rural Population", "Rural Percentage", "City Percentage", "City Population");
            System.out.printf("\u001B[37m%-30s %-20s %-20s %-20s %-20s %-20s%n", "==============", "================", "================", "===============", "===============", "===============");

            for(int z = 0; z < region.size() ; z++)
            {
                Long ruralpercent=null;
                Long citypercent=null;
                if(ruralpop.get(z) != 0 && citypop.get(z) != 0)
                {
                    ruralpercent = ruralpop.get(z) * 100;
                    ruralpercent = ruralpercent / countrypop.get(z);

                    citypercent = citypop.get(z) * 100;
                    citypercent = citypercent / countrypop.get(z);
                }
                System.out.printf("%-30s %-20s %-20s %-20s %-20s %-20s%n", region.get(z), countrypop.get(z), ruralpop.get(z), ruralpercent, citypercent, citypop.get(z));
            }
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

    public void getReport25()
    {

        ResultSet rset = null;
        Statement stmt = null;
        ArrayList<String> country = new ArrayList<>();
        ArrayList<Long> countrypop = new ArrayList<>();
        ArrayList<Long> citypop = new ArrayList<>();
        ArrayList<Long> ruralpop = new ArrayList<>();

        try
        {
            stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT DISTINCT country.name "
                            +"FROM country";
            // Execute SQL statement

            rset = stmt.executeQuery(strSelect);

            // Extract employee information




            while (rset.next())
            {
                String conlocation;
                conlocation = rset.getString("country.name");
                country.add(conlocation);
            }
            rset = null;
            stmt = null;

            for(int z = 0; z < country.size() ; z++)
            {
                // Create an SQL statement
                stmt = con.createStatement();
                // Create string for SQL statement
                strSelect =
                        "SELECT sum(country.population) "
                                + "FROM country "
                                + "WHERE country.name ='" + country.get(z) + "' ";
                // Execute SQL statement
                rset = stmt.executeQuery(strSelect);
                // Extract employee information

                while(rset.next())
                {
                    Long conpop;
                    conpop = rset.getLong("sum(country.population)");
                    countrypop.add(conpop);
                }
            }

            rset = null;
            stmt = null;

            for(int z = 0; z < country.size() ; z++)
            {
                // Create an SQL statement
                stmt = con.createStatement();
                // Create string for SQL statement
                strSelect =
                        "SELECT sum(city.population) "
                                + "FROM city, country "
                                + "WHERE country.name ='" + country.get(z) + "' "
                                + "AND country.code = city.countrycode";
                // Execute SQL statement
                rset = stmt.executeQuery(strSelect);
                // Extract employee information

                while(rset.next())
                {
                    Long citpop;
                    citpop = rset.getLong("sum(city.population)");
                    citypop.add(citpop);
                }
                long temp;
                temp = countrypop.get(z)-citypop.get(z) ;
                ruralpop.add(temp);
            }
            System.out.printf("\u001B[32m %n%s%n%n","A Report on the population of people, people living in cities, and people not living in cities in each country.");
            System.out.printf("\u001B[34m%-30s %-20s %-20s %-20s %-20s %-20s%n", "Country", "Total Population", "Rural Population", "Rural Percentage", "City Percentage", "City Population");
            System.out.printf("\u001B[37m%-30s %-20s %-20s %-20s %-20s %-20s%n", "==============", "================", "================", "===============", "===============", "===============");

            for(int z = 0; z < country.size() ; z++)
            {
                Long ruralpercent=null;
                Long citypercent=null;
                if(ruralpop.get(z) != 0 && citypop.get(z) != 0)
                {
                    ruralpercent = ruralpop.get(z) * 100;
                    ruralpercent = ruralpercent / countrypop.get(z);

                    citypercent = citypop.get(z) * 100;
                    citypercent = citypercent / countrypop.get(z);
                }
                System.out.printf("%-30s %-20s %-20s %-20s %-20s %-20s%n", country.get(z), countrypop.get(z), ruralpop.get(z), ruralpercent, citypercent, citypop.get(z));
            }
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
