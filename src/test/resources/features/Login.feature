@login
Feature: user Login funcationlity

  
  Scenario Outline: Login with valid credentials
  Given user navigates to login page
  #When user has enters valid emailaddress <username> into email field
  #And user has enters valid password <password> into password field
  When user has enters valid emailaddress '<username>' into email field
  And user has enters valid password '<password>' into password field
  And user clicks on login button
  Then user should get successfully logged in
  Examples:
  |username								|password		|
  |amotooricap1@gmail.com	|12345			|
  |amotooricap2@gmail.com	|12345			|
  |amotooricap3@gmail.com	|12345			|
  |asthakare@gmail.com		|Akash@6543	|
  
  @LoginSc02
  Scenario: Login with invalid credentials
  Given user navigates to login page
  When user has enters invalid emailaddress "asthak56gv@gmail.com" into email field
  And user has enters invalid password "Akash@65" into password field
  And user clicks on login button
  Then user should get proper warning message about given credentials mismatched
    
 	
  Scenario: Login with valid email and invalid password
	Given user navigates to login page
  When user has enters valid emailaddress "asthakare@gmail.com" into email field
  And user has enters invalid password "1234567" into password field
  And user clicks on login button
  Then user should get proper warning message about given credentials mismatched
   
  
  Scenario: Login with invalid email and valid password
	Given user navigates to login page
	When user has enters invalid emailaddress "asthakarfgv@gmail.com" into email field
	And user has enters valid password "Akash@6543" into password field
	And user clicks on login button
  Then user should get proper warning message about given credentials mismatched  
   
  
  Scenario: Login without credentials
	Given user navigates to login page
	And user clicks on login button
  Then user should get proper warning message about given credentials mismatched
    