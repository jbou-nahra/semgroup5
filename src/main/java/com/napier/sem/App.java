package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

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

        // Extract cities information
        //    ArrayList<City> cities = a.getAllcities();

        //display  cities information
        // a.printCities(cities);

        /*Report10To13 report10to13 = new Report10To13();
        report10to13.getReport10(); //produce a report on All the cities in a country organized by largest population to smallest
        report10to13.getReport11(); // produce a report on All the cities in a district organized by largest population to smallest
        report10to13.getReport12(); //produce a report on The Top N populated cities in the world where N is provided by the user
        report10to13.getReport13(); //produce a report on The Top N populated cities in the continent where N is provided by the user

        Report1To5 report1to5 = new Report1To5();
        report1to5.getReport1();*/

        Report6To9 report6To9 = new Report6To9();
        report6To9.getReport6();


        // Disconnect from database
        a.disconnect();

    }

}