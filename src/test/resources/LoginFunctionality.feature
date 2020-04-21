Feature: Login Functionality

@functional @adhoc 
Scenario Outline: Successfull login with valid credentials

Given user is on Login Page
When user enters valid "<Username>" and "<Password>"
And clicks on remember me checkbox
And clicks on Login button 
Then Message dispalyed Login Successfully "<expected result>"

Examples:
|Username |Password| expected result|
|admin    |manager | actiTIME - Enter Time-Track|
|admin1   |manager1| actiTIME - Login|
|admin1   |manager1| actiTIME - Login|
|admin    |manager | actiTIME - Enter Time-Track|

@adhoc 
Scenario: Unsuccessfull login with invalid credentials

Given user is on Login Page
When user enters valid Username "admin1" and Password "manager1"
And clicks on Login button 
Then Error message dispalyed

@Shopping_page-datatable
Scenario: user searches for the product

Given user is on home page
When user search for product
|product|quantity|
|shoes  |2		 |
|watches|3		 |
|bags   |5		 |
Then product page should be displayed

@Flipkart
Scenario Outline:

Given User is on Flipkart login page and enter valid "<username>" and "<password>"
When User is on Home page
When User is Product list page
#When User is on Product details page
#Then User is on Cart page

Examples:
|username          			 |password          |
|Mahaboobpasha224@gmail.com  |8884722587        |
|Mahaboobpasha225@gmail.com	 |8884722589		|

