@SYMU-375
Feature: 

	@SYMU-374
	Scenario: Verify that user should able to login with valid credentials2 - EC
		Given the user is on the log in page
		When the user enter valid credential
		And the user hit enter button
		Then the user should able to login
		And the user should be seen under profile icon as expected	


	@SYMU-376
	Scenario: Verify that user should able to login with valid credentials- EC
		Given the user is on the log in page
		When the user enter valid credential
		And the user click login button
		Then the user should able to login
		And the user should be seen under profile icon as expected	

	@SYMU-377
	Scenario Outline: Verify that user should not able to login any invalid credential - EC
		Given the user is on the log in page
		When the user enter invalid credentials as "<user>" and "<pass>"
		Then Verify that error message should be seen
		Examples:
		|user|pass|
		|Employee51|ABC|
		|ABC|Employee123|
		|A|A|	


	@SYMU-378
	Scenario Outline: Verify that user should not able to login any invalid credential2 - EC
		Given the user is on the log in page
		When the user enter invalid credentials as "<user>" and "<pass>"
		Then Verify that invalid message-1 should be seen
		Examples:
		|user|pass|
		|||
		||Employee123|	


	@SYMU-379
	Scenario: Verify that user should not able to login any invalid credential3 - EC
		Given the user is on the log in page
		When the user enter invalid credentials as wrongInput and blank
		Then Verify that invalid message-2 should be seen
			

	@SYMU-380
	Scenario: Verify that user should able to see the password in a form of dots by default - EC
		Given the user is on the log in page
		When the user enter any password
		Then the user should see dots as default	


	@SYMU-381
	Scenario: Verify that user can see the password explicitly if needed - EC
		Given the user is on the log in page
		When the user enter any password
		Then the user should see password if needed	


	@SYMU-382
	Scenario: Verify that user should able to see an option link like "forgot password" on the login page to be able to reset the password - EC
		Given the user is on the log in page
		Then the user should able to see forgot password button
		And the user should able to click forgot button
		Then the user should able to see reset password button	


	@SYMU-383
	Scenario: Verify that user shoul able to see valid placeholders on Username and Password fields - EC
		Given the user is on the log in page
		When the user send valid inputs into related buttons
		Then the user should able to see valid placeholder in the username box
		Then the user should able to see valid placeholder in the password box