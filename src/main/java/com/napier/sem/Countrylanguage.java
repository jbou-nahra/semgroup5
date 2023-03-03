package com.napier.sem;

import java.util.ArrayList;

/**
 * number of languages  in the world
 * */
public class Countrylanguage {


    /**
     * Abbreviated country names
     * */
    public String country_code;

    /**
     * name of language
     * */
    public String language;


    /**
     * Is official
     * */
    public char is_official;


    /**
     * percentage of person who speak they language
     * */
    public Integer percentage;

    static public void printReport(ArrayList<Countrylanguage> countryLanguages, String reportDes)
    {

        System.out.printf ( "\u001B[32m %n%s%n%n", reportDes);
        System.out.printf("\u001B[34m%-30s  %-30s%n ", "  Language", "World Percentage");
        System.out.printf("\u001B[37m%-30s %-30s%n", "=========", "================");

        for (Countrylanguage countryLang : countryLanguages)
        {
            System.out.printf("  %-30s     %-30s%n",
                    countryLang.language, countryLang.percentage);

        }
    }



}
