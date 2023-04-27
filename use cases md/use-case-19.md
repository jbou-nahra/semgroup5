# USE CASE: 19 All the capital cities in a region organised by largest to smallest.

## CHARACTERISTIC INFORMATION

### Goal in Context

As a *data analyst* I want *to produce a report on All the capital cities in a region organised by largest to smallest.* so that *I can support the survey and census reporting of the organisation.*

### Scope

Company.

### Level

Primary task.

### Preconditions

We know the region. Database contains current population data for all countries in the world

### Success End Condition

A report is available for the Data Analyst to provide to the survey and census department  .

### Failed End Condition

No report is produced.

### Primary Actor

Data Analyst

### Trigger

A request for population information is sent from survey and census to the Data Analyst.

## MAIN SUCCESS SCENARIO

1. survey and census request population information cities in the world in a given contains.
2. Data Analyst captures names of cities to get their population information
3. Data Analyst  extracts all cities population information and places them in  descending order
4. Data Analyst provides report to survey and census

## EXTENSIONS
2. **Continent  does not  exist.**
   i. Data Analyst informs survey and census that this region does  not exist or is not available.

3. **Population information may not be available for all cities**
   i. Report would be produce with cities having a null value
## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0
