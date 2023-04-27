# USE CASE: 20 The top N populated capital cities in the world where N is provided by the user.

## CHARACTERISTIC INFORMATION

### Goal in Context

As a *data analyst* I want the * top N populated capital cities in the world  so that *I can support the survey and census reporting of the organisation.*

### Scope

Company.

### Level

Primary task.

### Preconditions

We know the desired number N,  Database contains current population data for all countries in the world

### Success End Condition

A report is available for the Data Analyst to provide to the survey and census department  .

### Failed End Condition

No report is produced.

### Primary Actor

Data Analyst

### Trigger

A request for population information is sent from survey and census to the Data Analyst.

## MAIN SUCCESS SCENARIO

1. survey and census request a list of N population for  cities in the world
2. Data Analyst captures names of cities to get the population information
3. Data Analyst  extracts all cities  with a population that is Equal to or greater than N
4. Data Analyst provides report to survey and census

## EXTENSIONS
2. **number enter does not  exist.**
   i. Data Analyst informs survey and census that this N number does  not exist or is not available.


## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0
