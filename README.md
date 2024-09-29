# EntrataSeleniumTests
Selenium tests to explore and validate the functionality of entrata.com
# Selenium Test Suite for Entrata.com

## Overview
This project contains a set of Selenium WebDriver tests to explore and validate the functionality of Entrata.com. The tests are written in Java using TestNG,SLF4J  and Maven as the build tool.

## Prerequisites
- Java 8+
- Maven
- ChromeDriver (Ensure it's compatible with your Chrome version)

## Setup

### 1. Clone the Repository
```bash
git clone https://github.com/divyanshusingh700/EntrataSeleniumTests.git
cd EntrataSeleniumTests
```
### 2. Clone the Repository
Make sure Maven is installed, then install the project dependencies by running:
    ```bash
    mvn clean install
    ```
### 3. Configuring SLF4J Logging
SLF4J is used for logging purposes in this project. It requires a binding to a specific logging implementation.
### 4. Running the Tests
## Command to Run Tests

    ```bash
    mvn verify
    ```
This will:

Compile the code.
Run all tests in the project using TestNG.
Generate a test report.
## Test Cases
1. **Home Page Title Test**: Validates that the home page title is correct.
2. **Careers Page Navigation**: Ensures the user can navigate to the Careers page.
3. **Entrata overview video Test**: Selenium test that verifies when the video button is clicked, the iframe box becomes visible.
4. **Resources and download Test**: Verify the functionality of clicking on the "See all Resources" link and the "Download Now" button that opens in a new tab.
5. **Link navigation Test**: Verify the behavior of clicking the "Resident Login" link and ensuring that the respective URLs open correctly.

## Note
Tests are designed to run on the Chrome browser by default.

