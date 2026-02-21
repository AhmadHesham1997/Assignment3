Swag Labs Automation Assignment

Objective:
Write an automated test script for the Swag Labs website ( https://www.saucedemo.com/ ) using Selenium WebDriver and TestNG, following the Page Object Model (POM) design pattern 
and Data-Driven Testing approach (with JSON).
You will design a simple automation framework that tests the Login functionality and verifies basic elements on the Inventory page after a successful login.

Requirements:
Your framework should include the following components:
•	BaseTest class → for browser setup and teardown.
•	LoginPage class → contains locators and methods related to the login page.
•	InventoryPage class → contains locators and methods for the inventory page.
•	DataDriven class → contains a jsonReader() method to read data from JSON file.
•	testData.json → stores test data (valid and invalid login credentials).
•	LoginTest class → contains all login-related test methods.
•	InventoryTest class → contains tests to verify inventory page elements after login

Project Structure:
 
Test Scenarios:
1-	Verify Successful Login
•	Steps:
o	Navigate to https://www.saucedemo.com
o	Enter a valid username and a valid password from JSON
o	Click Login
o	Verify that the user is redirected to the Inventory page (URL contains /inventory.html)

2-	 Verify Invalid Login
•	Steps:
o	Enter invalid username and invalid password from JSON
o	Click Login
o	Verify that the displayed error message contains the text:
"Username and password do not match"


3-	 Verify Login Without Password
•	Steps:
o	Enter a valid username, but leave the password field empty
o	Click Login
o	Verify that the displayed error message contains the text:
"Password is required"

4-	 Verify Inventory Page Elements After Login
•	Steps:
o	Login successfully using valid credentials
o	Verify that:
	The page title is "Swag Labs"
	The cart icon is displayed
	There are 6 products displayed on the Inventory page

Notes:
1.	Follow the Page Object Model (POM) design pattern.
2.	All test data must be loaded from the JSON file using the jsonReader() method in DataDriven.java.
3.	Use TestNG annotations for setup, teardown, and tests.
4.	Use assertions to validate each expected result.
5.	Keep your code modular, readable, and well-commented.

Submission Instructions:
•	Create a new GitHub repository for this project.
•	Push your complete project (including all source code and JSON file) to the repository.
•	Make sure your repository is set to Public.
•	Send your repo link via email to: soadmagdy .route@gmail.com
o	Mail Subject: Automation Task 3 [Your Name] – [your group]
(Example: Automation Task 3 [Abdelrhman Aboelenan] – G3)


