# USE CASE: 1 Produce a Report on All the Countries in the World organized by largest population to smallest 

## CHARACTERISTIC INFORMATION

### Goal in Context

As a *data analyst* I want *to produce a report of all the countries in the world organized by largest population to smallest* in order *to support the survey and census reporting of the organization.*
### Scope

Company.

### Level

Primary task.

### Preconditions

Database contains current population data for all countries in the world.

### Success End Condition

A report is available for Data Analyst to use in the census and survey reporting of the organization.

### Failed End Condition

No report is produced.

### Primary Actor

Data Analyst.

### Trigger

A request for World population statistics is required directly or indirectly by organization.

## MAIN SUCCESS SCENARIO

1. A need arises for World population statistics report.
2. Data Analyst makes request for data on application.
3. Data Analyst extracts population data for all countries in the world.
4. Data Analyst provides report organized from largest to smallest.

## EXTENSIONS

3. **Data does not exist for all countries**:
    1. Data analyst makes a report on all countries that are available, and advises that data is not available for all countries.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0
