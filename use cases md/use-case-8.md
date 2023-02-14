#USE CASE: 8 produce a report on All the cities in a continent in the world by population from largest to smallest 

## CHARACTERISTIC INFORMATION

### Goal in Context

As a *data analyst * I want * to produce a report on All the cities in a continent in the world by population from largest to smallest * so that *i can support the survey and census reporting of the organisation.*

### Scope

Company.

### Level

Primary task.

### Preconditions

We know the continent. Database contains current population data for all countries in the world.

### Success End Condition

A report is available for the Data Analyst to provide to the survey and census department  .

### Failed End Condition

No report is produced.

### Primary Actor

Data Analyst

### Trigger

A request for population information is sent from survey and census to the Data Analyst.

## MAIN SUCCESS SCENARIO

1. survey and census request population information cities in a continent in the world  
2. Data Analyst captures names of cities in a continent to get their population
3. Data Analyst  extracts all cities population information in form their repected continent's  in a descending order 
4. Data Analyst provides report to survey and census  department 

## EXTENSIONS

3. **Data does not exist for all countries**:
    1. Data Analyst informs survey and census department no role exists.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0
