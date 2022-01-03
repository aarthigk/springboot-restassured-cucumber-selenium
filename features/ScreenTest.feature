@tag
Feature: Register in e-commerce site feature
  I want to use this template for my feature file

  @tag4
  Scenario: Enter details in ecommerce site
    Given user navigates to nopcommerce site
    And user clicks register link
    Then user sees register page
    And the user chooses gender
    When user enters the following details in register page
    	|Field				|	values						|
      | First name 	| Testera 					| 
      | Last name 	| Atest 						|
      | Email 			| atest@testing.com | 
    And the user chooses "date","month",and "year" in date of birth dropdown
    Then the user fills the company details,your password and confirm password
    Then the user unchecks the options chekcbox
    When the user clicks the register button
    Then the user see "Your registration completed" message
    
    
