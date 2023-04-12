package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

public class ReportLanguages {

    private Connection con;

    ReportLanguages()
    {

        try
        {
            con = App.getDBConnection();

        }catch (Exception e)
        {
            System.out.println( e.getMessage());
        }
    }

    public void getReportLanguages()

    {
        ResultSet rset = null;
        Statement stmt = null;
        // String countryCode ="";

        ArrayList<Countrylanguage> countrylanguages = new ArrayList<>();

        String reportDes = String.format("A report on the number of persons in the world that speaks the following langauges ordered by Percentage" );


        try
        {

            // Create an SQL statement
            stmt = con.createStatement();
            // Create string for SQL statement

            String sqlBatchStr1 = "SET @world_Pop = (select sum(Population) from country);  ";

            String sqlBatchStr2 =
                              " SELECT Language,  (sum(Population)/@world_Pop * 100) as Percentage"
                            + " FROM country "
                            + " INNER JOIN countrylanguage "
                            + " ON CountryCode = Code"
                            + " WHERE Language = 'Chinese' or Language = 'English' or Language = 'Hindi' or Language = 'Spanish' or Language = 'Arabic' "
                            + " group by Language "
                            + " ORDER BY Percentage DESC ";

            stmt.addBatch( sqlBatchStr1);
            stmt.executeBatch();
             rset = stmt.executeQuery(sqlBatchStr2);


            while (rset.next())
            {
                Countrylanguage cl = new Countrylanguage();
                cl.language= rset.getString("language");
                cl.percentage = rset.getInt("Percentage");

                countrylanguages.add(cl);
            }

            Countrylanguage.printReport(countrylanguages, reportDes);

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());

        }
        finally
        {
            try { if (rset != null) rset.close(); } catch (Exception e) {System.out.println(e.getMessage());}
            try { if (stmt != null) stmt.close(); } catch (Exception e) {System.out.println(e.getMessage());}
            //     try { if (con != null) con.close(); } catch (Exception e) {};

        }

    }
}
