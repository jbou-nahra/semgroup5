package com.napier.sem;

import java.sql.*;

public class App
{
    /**
     * Connection to MySQL database.
     */
    static private Connection con = null;

    /**
     * Method to get DB Connecton
     * */

    static public Connection getDBConnection()
    {
        return con;
    }


    /**
     * Connect to the MySQL database.
     */
    public void connect(String location, int delay)
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

        int retries = 3;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location
                                + "/world?allowPublicKeyRetrieval=true&useSSL=false",
                        "root", "example");
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
        if(args.length < 1){
            a.connect("localhost:33060", 30000);
        }else{
            a.connect(args[0], Integer.parseInt(args[1]));
        }

        ArrayList<City> cities = new ArrayList<>();
        String continent = "Europe";
        String region = "Western Europe";
        String country = "China";
        String district = "Casablanca";
        String city = "New York";
        int n = 10;
        int limit = 3;
        String region2 ="caribbean";
        String continent2= "asia";
        //Report 1 to 5 done by Jean Bou-Nahra
        Report1To5 report1to5 = new Report1To5();
        report1to5.getReport1();//All the countries in the world organised by largest population to smallest.
        report1to5.getReport2(continent);//All the countries in a continent organised by largest population to smallest.
        report1to5.getReport3(region);//All the countries in a region organised by largest population to smallest.
        report1to5.getReport4(n);//The top N populated countries in the world where N is provided by the user.
        report1to5.getReport5(continent,n);//The top N populated countries in a continent where N is provided by the user.

        //Report 6 to 9 done by Jerome Burke III
        Report6To9 report6To9 = new Report6To9();
        report6To9.getReport6(limit,region2);//report on the top N populated countries in a region in the world
        report6To9.getReport7();// report on All the cities in the world organised by population from the largest to the smallest
        report6To9.getReport8(continent2);// report on All the cities in a continent  in the world by population from largest to smallest
        report6To9.getReport9(region);//report on All the cities in a region  in the world organised by population from the largest to the smallest

        //Report 10 to 13 done by Damian Daley
        Report10To13 report10to13 = new Report10To13();
        cities = report10to13.getReport10("United Kingdom"); //produce a report on All the cities in a country organized by largest population to smallest
        City.printReport(cities);

        cities = report10to13.getReport11("England"); // produce a report on All the cities in a district organized by largest population to smallest
        City.printReport(cities);

        cities = report10to13.getReport12(10); //produce a report on The Top N populated cities in the world where N is provided by the user
        City.printReport(cities);

        cities = report10to13.getReport13(10, "Africa"); //produce a report on The Top N populated cities in the continent where N is provided by the user
        City.printReport(cities);
        //Report 14 to 17 done by Nesreen Tittle
        Report14To17 report14to17 = new Report14To17();
        report14to17.getReport14(); //produced a report the top N populated cities in a region where N is provided by the user.
        report14to17.getReport15();//produced a report on the top N populated cities in a country where N is provided by the user.
        report14to17.getReport16(2);//produced a report on the top N populated cities in a district where N is provided by the user.
        report14to17.getReport17();//produced a report on all the capital cities in the world organised by largest population to smallest.

        Report18To21 Report18To21 = new Report18To21();
        Report18To21.getReport18(continent);
        Report18To21.getReport19(region);
        Report18To21.getReport20(n);
        Report18To21.getReport21(continent, n);

        Report22To25 report22To25 = new Report22To25();
        report22To25.getReport22(region, n);
        report22To25.getReport23();
        report22To25.getReport24();
        report22To25.getReport25();

        Report26To31 report26To31 = new Report26To31();
        report26To31.getReport26();
        report26To31.getReport27(continent);
        report26To31.getReport28(region);
        report26To31.getReport29(country);
        report26To31.getReport30(district);
        report26To31.getReport31(city);

        ReportLanguages reportLanguages = new ReportLanguages();
        reportLanguages.getReportLanguages();

        // Disconnect from database
        a.disconnect();
    }

}