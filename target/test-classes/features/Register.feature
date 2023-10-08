Feature: user Registeration Functionality
  

  	Scenario: user create an account only with mandatory fields
  	Given User navigates to registeration page
    When User enters the details into below fields
    |firstName	|akash10									|
    |lastname		|thakare10								|
    |telephone	|5678903421								|
    |password		|akash012310							|
    And user selects privacy policy
    And user clicks on continue button
    Then user account should get an account created successfully
    
   
  	Scenario: user create an account only with all fields
  	Given User navigates to registeration page
    When User enters the details into below fields
    |firstName	|akash11									|
    |lastname		|thakare12								|
    |telephone	|5678903412								|
    |password		|akash012312							|
    And user selects yes for newsletter
    And user selects privacy policy
    And user clicks on continue button
    Then user account should get an account created successfully
    
    
   
  	Scenario: user creates account with duplicate email
  	Given User navigates to registeration page
    When User enters the details into below fields with duplicate email
    |firstName	|akash09									|
    |lastname		|thakare09								|
    |email			|akashthakare09@gmail.com	|
    |telephone	|5678903421								|
    |password		|akash011234							|
    And user selects yes for newsletter
    And user selects privacy policy
    And user clicks on continue button
    Then user should get proper warning message about duplicate email
    
   
  	Scenario: user creates an without filling any details
  	Given User navigates to registeration page
    And user clicks on continue button
    Then user should get proper warning message for every mandatory fields
    
    
    
   