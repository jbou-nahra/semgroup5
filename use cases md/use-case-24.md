# USE CASE: 24 The population of people, people living in cities, and people not living in cities in each region.

## CHARACTERISTIC INFORMATION

### Goal in Context

As a *data analyst* I want the *  population of people, people living in cities, and people not living in cities in each region. so that *I can support the survey and census reporting of the organisation.*

### Scope

Company.

### Level

Primary task.

### Preconditions

we know the region  Database contains current population data for all countries in the world

### Success End Condition

A report is available for the Data Analyst to provide to the survey and census department  .

### Failed End Condition

No report is produced.

### Primary Actor

Data Analyst

### Trigger

A request for population information is sent from survey and census to the Data Analyst.

## MAIN SUCCESS SCENARIO

1. survey and census request a list of The population of people, people living in cities, and people not living in cities
2. Data Analyst captures names of cities to in a continent and name of the districts in a region  to get the population information
3. Data Analyst  extracts cities  with a population  and districts
4. Data Analyst provides report to survey and census

## EXTENSIONS
2. ** Region does not  exist.**
   i. Data Analyst informs survey and census that this region does  not exist or is not available.

3. ** Data does not exist for all  cities and all districts **
   i. Data analyst makes a report on that no data is available for cities and districts


## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0
