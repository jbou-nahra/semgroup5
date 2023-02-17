## Characteristic Information

## Goal in Context
As a data analyst I want to produce a report on the top N populated cities in a region where N is Provided by the user as a way to support the survey and census reporting of the organization

## Scope
Company

## Level
Primary task

## Preconditions
We know the number N and the region. Database contains current population data for all cities in the world and region they reside.

## Success End Condition
A report is available for the Data Analyst to use in the census and survey reporting of the organization.

## fail end condition
No report is produced

## Primary Actor
Data Analyst

## Trigger
A request for the top N populated cities in a region is required  by the organization.

## Main Success scenario
1.	Data Analyst input a number N which represents the relevant number of top populated cities in a particular region
2.	Data Analyst acquires data on all cities in the region
3.	Data Analyst selects the top N populated cities in the region
4.	Data Analyst generate the report on the top N populated cities in the region

## Extension
2.Data is not provided for all cities in the region
(i) Data Analyst informs the organization that data is not available for all cities in the region and give report on what are available

## Sub-Variations
None

## Schedule
Due Date: Release 1.0


