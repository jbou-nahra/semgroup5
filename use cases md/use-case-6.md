#USE CASE: 6  produce a report on the top N populated countries in a region in the world

## CHARACTERISTIC INFORMATION

### Goal in Context

As a *data analyst* I want the *top N populated countries in a region in the world* so that *i can support the survey and census reporting of the organisation.*

### Scope

Company.

### Level

Primary task.

### Preconditions

We know the desired number N and we know the region. Database contains current population data for all countries in the world

### Success End Condition

A report is available for the Data Analyst to provide to the survey and census department  .

### Failed End Condition

No report is produced.

### Primary Actor

Data Analyst

### Trigger

A request for population information is sent from survey and census to the Data Analyst.

## MAIN SUCCESS SCENARIO

1. survey and census request a list of   N population  for a given country in a given region 
2. Data Analyst captures names of countries in a region to get the population information 
3. Data Analyst  extracts all countries with  with a population that is Equal to or greater than N 
4. Data Analyst provides report to survey and census 

## EXTENSIONS
3. **Data does not exist for all countries**:
    1. Data Analyst informs survey and census department no role exists.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0
