# Test Framework: Java, Selenium and JUnit 5

## Description

This project is a test automation framework developed in Java, using Selenium WebDriver, JUnit 5, and the Page Object Model (POM) design pattern. It is designed to facilitate functional testing automation for web applications.

## Features

- **Modular design:** Implementation of the Page Object Model pattern.

- **Data sharing:** Context management for sharing variables across tests.

- **Efficient organization:** Separation of test cases into categories such as smoke and regression.

- **Dependency management:** Maven is used to manage libraries.

## Technologies Used

- **Language:** Java 20

- **Test Framework:** JUnit 5

- **Web Automation:** Selenium WebDriver

- **Dependency Manager:** Maven

## Project Structure
```bash
|-- src
    |-- main
        |-- java
            |-- common
            |-- context
            |-- pages
        |-- resources
    |-- test
        |-- java
            |-- common
            |-- data
            |-- extensions
            |-- hooks
            |-- tests
        |-- resources
```
- **main/java/common:** Utility classes shared across tests.

- **main/java/context:** Class for sharing variables and data between tests, which allows storing, retrieving, and managing key-value pairs during test execution.

- **main/java/pages:** Classes representing the web pages under test.

- **test/java/common:** Class to provide a collection of common steps shared across multiple tests

- **test/java/data:** Test data providers and management.

- **test/java/extensions:** Classes for log handling and custom configurations.

- **test/java/hooks:** Pre- and post-condition handlers for test scenarios.

- **test/java/tests:** Automated test cases.

- **resources:** Configuration files required for test execution.

## Setup

1. Clone the repository:
```bash
git clone https://github.com/julianmancuello/test-framework-Java-Selenium.git
```
2. Import the project into IntelliJ IDEA or any compatible IDE.
3. Ensure Java 20 is configured in the ```PATH```.
4. Run:
```bash
mvn clean test
```

## Test Execution

- Run all tests:
```bash
mvn test
```
- Run smoke tests:
```bash
mvn test -Dgroups=smoke
```
- Run regression tests:
```bash
mvn test -Dgroups=regression
```

## Author
**Julian Ezequiel Mancuello**


