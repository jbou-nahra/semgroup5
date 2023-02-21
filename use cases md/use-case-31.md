# USE CASE: 31 produce a report on the number of people who speaks Chinese, English , Hindi, Spanish And Arabic languages in the world

## CHARACTERISTIC INFORMATION

### Goal in Context

As a *data analyst* I want  *to produce a report on the number of people who speaks Chinese, English , Hindi, Spanish And Arabic languages in the world* and arrange them, from the largest to the smallest.  *I can support the survey and census reporting of the organisation.*

### Scope

Company.

### Level

Primary task.

### Preconditions

we know the languages. Database contains current population data for all countries in the world

### Success End Condition

A report is available for the Data Analyst to provide to the survey and census department

### Failed End Condition

No report is produced.

### Primary Actor

Data Analyst

### Trigger

A request for population information is sent from survey and census to the Data Analyst.

## MAIN SUCCESS SCENARIO

1. survey and census request a population of the world that speak different languages
2. Data Analyst captures name of each language to get the population information for
3. Data Analyst  extracts  Population for that language
4. Data Analyst provides report to survey and census


## EXTENSIONS
3. **language  does not exist **
   i Data Analyst informs survey and census that this language  does  not exist or is not available.
## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0
