# USE CASE: 7 produce a report on All the cities in the world organised by population from the largest to the smallest 

## CHARACTERISTIC INFORMATION

### Goal in Context

As a *data analyst* I want * to produce a report on All the cities in the world organised by population from the largest to the smallest* so that *I can support the survey and census reporting of the organisation.*

### Scope

Company.

### Level

Primary task.

### Preconditions

Database contains current population data for all countries in the world and all cities that reside in them.

### Success End Condition

A report is available for the Data Analyst to provide to the survey and census department  .

### Failed End Condition

No report is produced.

### Primary Actor

Data Analyst

### Trigger

A request for population information is sent from survey and census to the Data Analyst.

## MAIN SUCCESS SCENARIO

1. survey and census request population information of all  cities in the world in descending order 
2. Data Analyst captures names of cities to get their population information
3. Data Analyst  extracts all cities population information and places them in  descending order 
4. Data Analyst provides report to survey and census 

## EXTENSIONS
3. **Population information may not be available for all cities**
   i. Report would be produce with cities having a null value 


## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0
