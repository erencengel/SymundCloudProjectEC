@SYMU-388
Feature: 

	@SYMU-389
	Scenario: Verify that user can log out and ends up in login page - EC
		Given the user is on the log in page
		And the user enter valid credential and login
		When the user should able to log out
		Then verify user logout	

	@SYMU-390
	Scenario: Verify that user should not able to go to home page again by clicking step back button after successfully loged out. - EC
		Given the user is on the log in page
		And the user enter valid credential and login
		When the user should able to log out
		Then verify that user can not go to home page again by clicking step back button