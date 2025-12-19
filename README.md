# BlazeDemo – Book a Flight Hybrid Automation Framework

## Overview
Hybrid Automation Framework developed using Selenium WebDriver with Java to automate the flight booking workflow in the BlazeDemo web application. The framework is designed using Page Object Model (POM) and data-driven testing concepts to ensure code reusability and maintainability.

## Application Under Test
- Application: BlazeDemo
- URL: https://blazedemo.com
- Workflow: Search Flight → Select Flight → Book Flight

## Tech Stack
- Java
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- Apache POI (Excel)

## Framework Features
- Hybrid Automation Framework
- Page Object Model (POM) implementation
- Data-driven testing using Excel
- Centralized configuration using properties file
- Modular and maintainable test design


## Project Structure
```
BookaFlight-Hybrid-Framework
│
├── src/main/java
│   ├── base
│   │   └── BaseTest.java
│   │
│   ├── pages
│   │   ├── HomePage.java
│   │   ├── FlightPage.java
│   │   ├── PurchasePage.java
│   │   └── ConfirmationPage.java
│   │
│   └── utils
│       ├── ConfigReader.java
│       └── ExcelUtils.java
│
├── src/main/resources
│
├── src/test/java
│   └── tests
│       └── BookFlightTest.java
│
├── src/test/resources
│   ├── config.properties
│   └── FlightData.xlsx
│
├── pom.xml
├── target
└── test-output

```
## Test Flow

1. Launch browser
2. Open BlazeDemo application
3. Select departure and destination cities
4. Search available flights
5. Choose a flight
6. Enter passenger and payment details
7. Submit booking
8. Verify booking confirmation message 
9. Close browser

## How to Run
- Run test classes using TestNG from Eclipse
- Or execute tests using Maven command:
  mvn test

