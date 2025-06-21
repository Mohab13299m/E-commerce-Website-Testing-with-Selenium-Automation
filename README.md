# E-commerce Website Testing

Automated functional tests for an e-commerce website using Java, Maven, Selenium WebDriver, and TestNG.

## Prerequisites

- Java JDK 8 or higher
- Maven 3.x
- Chrome, Firefox, or Edge browser installed
- ChromeDriver, GeckoDriver, or EdgeDriver available in your system PATH

## Project Structure

- `src/main/java` - Source code (utilities, listeners, Pages, driver factory)
- `src/test/java` - Test classes
- `Test Runner/Functional_Testing.xml` - TestNG suite configuration
- `TestOutput/target/surefire-reports' - TestNG HTML reports

## Setup

1. **Clone the Repository**
   ```bash
   git clone (https://github.com/Mohab13299m/E-commerce-Website-Testing-with-Selenium-Automation.git)

## Running Tests

Via TestNG XML:
1- Open Terminal
2- write mvn clean 
3- write mvn -DsuiteXmlFile="Test Runner/Functional_Testing.xml" test

##Test Reports
After execution, open test-output/index.html in your browser to view the TestNG report.

