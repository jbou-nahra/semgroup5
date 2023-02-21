# USE CASE: 28  produce a report on the population of a region in the world

## CHARACTERISTIC INFORMATION

### Goal in Context

As a *data analyst* I want  *to produce a report on the population of a region in the world* so that *I can support the survey and census reporting of the organisation.*

### Scope

Company.

### Level

Primary task.

### Preconditions

we know the region. Database contains current population data for all countries in the world

### Success End Condition

A report is available for the Data Analyst to provide to the survey and census department

### Failed End Condition

No report is produced.

### Primary Actor

Data Analyst

### Trigger

A request for population information is sent from survey and census to the Data Analyst.

## MAIN SUCCESS SCENARIO

1. survey and census request a population of a region
2. Data Analyst captures name of the region to get the population information 
3. Data Analyst  extracts  Population for that region
4. Data Analyst provides report to survey and census


## EXTENSIONS
3. **region does not exist **
   i Data Analyst informs survey and census that this region  does  not exist or is not available.
## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0
