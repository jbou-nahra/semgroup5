# USE CASE: 21 The top N populated capital cities in a continent 

## CHARACTERISTIC INFORMATION

### Goal in Context

As a *data analyst* I want the *  top N populated capital cities in a continent  so that *I can support the survey and census reporting of the organisation.*

### Scope

Company.

### Level

Primary task.

### Preconditions

We know the desired number N,we know the continent  Database contains current population data for all countries in the world

### Success End Condition

A report is available for the Data Analyst to provide to the survey and census department  .

### Failed End Condition

No report is produced.

### Primary Actor

Data Analyst

### Trigger

A request for population information is sent from survey and census to the Data Analyst.

## MAIN SUCCESS SCENARIO

1. survey and census request a list of N population for a continent in the world
2. Data Analyst captures names of cities to in a continent to get the population information
3. Data Analyst  extracts all cities  with a population that is Equal to or greater than N
4. Data Analyst provides report to survey and census

## EXTENSIONS
2. ** continent does not  exist.**
i. Data Analyst informs survey and census that this continent does  not exist or is not available.

3. ** Data does not exist for all countries  **
   i. Data analyst makes a report on all countries that are available, and advises that data is not available for all countries.


## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0
