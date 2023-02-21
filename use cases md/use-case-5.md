# USE CASE: 5 Produce a Report of the Top N Populated Countries in a Continent where N is Provided by the User

## CHARACTERISTIC INFORMATION

### Goal in Context

As a *data analyst* I want *to produce a report of the top N countries in a continent where N is provided by the user* in order *to support the survey and census reporting of the organization.*
### Scope

Company.

### Level

Primary task.

### Preconditions

We know the desired number N and the desired continent. Database contains current population data for all countries in the world and the continent they reside.

### Success End Condition

A report is available for Data Analyst to use in the census and survey reporting of the organization.

### Failed End Condition

No report is produced.

### Primary Actor

Data Analyst.

### Trigger

A request for World population statistics on top N populated countries in a continent is required directly or indirectly by organization.

## MAIN SUCCESS SCENARIO

1. A need arises for World population statistics report.
2. Data Analyst acquires desired number N of desired countries and continent in which they reside.
3. Data Analyst makes request for data on application.
4. Data Analyst extracts top N populated countries for that continent.
5. Data Analyst provides report.

## EXTENSIONS

1. **N is too large for dataset**:
    1.1 Data analyst makes a report on countris that are available, and advises that N is too large.
2. **Continental data is not present**:
	2.1 Data analyst advises that data based on continent is not available.

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0
