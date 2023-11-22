# ITI_WebAutomation_GP
# Selenium E2E Project on https://demo.nopcommerce.com

## Introduction
This Test Automation Framework is created using Java + Selenium Web Driver + TestNG + Maven Page Object Model(POM). 
Which can be used across different web based applications.It is used to make the code more readable, maintainable and reusable.

## Technologies/Tools used in building the framework
- IntelliJ IDEA - IDE
- Selenium - Browser Automation library
- Maven - Build automation tool
- Java - Programming language
- TestNG - Test Management library
- Extent Reports - Allure Reporting framework
- GitHub - Version control

## Steps to clone execute the tests
`git clone  https://github.com/ShaimaaAtta/ITI_WebAutomation_GP.git`<br/>
 `cd CommerceProject`<br/>
 `mvn clean install`<br/>
 `mvn test`

## Reporting
- The framework produce index.html report. It resides in the reports folder.This reports gives the link to all the different component of the TestNG reports like Groups & Reporter Output. On clicking these will display detailed descriptions of execution.
## Steps to generate Allure Report
- The framework produce allure-results report:<br/> 
  -cd CommerceProject<br/>
  -allure.bat serve allure-results<br/>

## E2E Scenairo
-User can Register successfully<br/>
-User can login successfully<br/>
-User can access his account to check saved credentials<br/>
-User can Hover over Electronics tab and select Cellphones category<br/>
-User can select a Cellphone then add it his Shopping cart<br/>
-User can verify his Shopping cart</br>
-User can change quantity of a product<br/>   	
-User can find a Mac product using search Box then add it to his cart<br/>
-User can re-verify his Shopping cart<br/>
-User can check if Mac product is added successfully<br/>
-User can remove item from Shopping cart<br/>
-User can Checkout successfully<br/>
  -Fill Bill information<br/>
  -Select Shipping Method<br/>
  -Select Payement method(Ex:credit card)<br/>
  -Confirm order<br/>
-User can download order Invoice pdf  

