## Use Case: 13

To print a report on Top N populated cities in the country

## Goal in Context

As a Data Analyst, I want to produce a report on The Top N populated cities in the continent where N is provided by the user so that I can support the survey and census reporting of the organisation

## Scope

World Database

## Level

Reporting

## Preconditions

Having a world database that contains correct and current population information of each city the continent

### Success End Condition

The user can query the top N most populated cities within a continent.

### Failed End Condition

1. Database contain incorrect information
2. Cities are not ranked in the correct order based on population
3. No report is produced

### Primary Actor

Data Analyst

### Trigger

A user wants to know the top N most populated cities within a continent

## MAIN SUCCESS SCENARIO

Database must contain correct information
The correct database query needs to be executed

## EXTENSIONS

Database gets updated with more current information

## SUB-VARIATIONS

None.

## SCHEDULE

**DUE DATE**: Release 1.0
