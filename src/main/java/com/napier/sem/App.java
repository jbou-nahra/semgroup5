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

        //Report 1 to 5 done by Jean Bou-Nahra
        Report1To5 report1to5 = new Report1To5();
        report1to5.getReport1();//All the countries in the world organised by largest population to smallest.
        report1to5.getReport2();//All the countries in a continent organised by largest population to smallest.
        report1to5.getReport3();//All the countries in a region organised by largest population to smallest.
        report1to5.getReport4();//The top N populated countries in the world where N is provided by the user.
        report1to5.getReport5();//The top N populated countries in a continent where N is provided by the user.

        //Report 6 to 9 done by Jerome Burke III
        Report6To9 report6To9 = new Report6To9();
        report6To9.getReport6();//report on the top N populated countries in a region in the world
        report6To9.getReport7();// report on All the cities in the world organised by population from the largest to the smallest
        report6To9.getReport8();// report on All the cities in a continent  in the world by population from largest to smallest
        report6To9.getReport9();//report on All the cities in a region  in the world organised by population from the largest to the smallest


        //Report 10 to 13 done by Damian Daley
        Report10To13 report10to13 = new Report10To13();
        report10to13.getReport10(); //produce a report on All the cities in a country organized by largest population to smallest
        report10to13.getReport11(); // produce a report on All the cities in a district organized by largest population to smallest
        report10to13.getReport12(); //produce a report on The Top N populated cities in the world where N is provided by the user
        report10to13.getReport13(); //produce a report on The Top N populated cities in the continent where N is provided by the user

        //Report 14 to 17 done by Nesreen Tittle
        Report14To17 report14to17 = new Report14To17();
        report14to17.getReport14(); //produced a report the top N populated cities in a region where N is provided by the user.
        report14to17.getReport15();//produced a report on the top N populated cities in a country where N is provided by the user.
        report14to17.getReport16();//produced a report on the top N populated cities in a district where N is provided by the user.
        report14to17.getReport17();//produced a report on all the capital cities in the world organised by largest population to smallest.


        ReportLanguages reportLanguages = new ReportLanguages();
        reportLanguages.getReportLanguages();


        // Disconnect from database
        a.disconnect();



    }

}