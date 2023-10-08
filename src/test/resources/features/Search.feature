@search
Feature: product search Functionality
  
  @search01
  Scenario: user searches for valid product
  When users opens the application
  And user enters product name "HP" into search field
  And user clicks on search button
  Then user should get valid product displayed in search result
  

  Scenario: user searches for invalid product
  When users opens the application
  And user enters product name "Honda" into search field
  And user clicks on search button
  Then user should get a message about no product found  
  
 
  Scenario: user searches without product name
  When users opens the application
  And user enters product name "" into search field
  And user clicks on search button
  Then user should get a message about no product found  