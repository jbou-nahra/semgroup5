# USE CASE: 3 Produce a Report of All the Countries in a Region Organized by Largest Population to Smallest 

## CHARACTERISTIC INFORMATION

### Goal in Context

As a *data analyst* I want *to produce a report of all the countries in a region organized by largest population to smallest* in order *to support the survey and census reporting of the organization.*
### Scope

Company.

### Level

Primary task.

### Preconditions

We know the region.  Database contains current population data for all countries in the world and the continent they reside.

### Success End Condition

A report is available for Data Analyst to use in the census and survey reporting of the organization.

### Failed End Condition

No report is produced.

### Primary Actor

Data Analyst.

### Trigger

A request for World population statistics based on region is required directly or indirectly by organization.

## MAIN SUCCESS SCENARIO

1. A need arises for World population statistics report.
2. Data Analyst acquires desired region for report.
3. Data Analyst extracts populated countries for that regioin.
4. Data Analyst provides report organized from largest to smallest popoulated countries.

## EXTENSIONS

1. **Data does not exist for all countries in region**:
    1.1 Data analyst makes a report on countries that are available, and advises that database is lacking.
2. **Data is not tagged by region**:
	2.1 Data analyst advises that regional data is not available in database.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0
