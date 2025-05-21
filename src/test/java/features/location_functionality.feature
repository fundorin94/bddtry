Feature: Location Features
  I am a user
  I want to interact with location features
  To verify content is displayed correctly

  //Background:
   // When I consent data usage

  Scenario: Display current location label

    When I click search field
    Then Use your current location label is displayed

  Scenario: Recent locations functionality

    When I input "London" in the search field
    And I click on the first search result
    And I go back to the main page
    Then Main page is opened
    When I choose the first city in Recent locations
    And I close the Ad block
    Then City weather page header contains city name "London" from the search



  Scenario: Search for a city

    When I input "New York" in the search field
    Then Search results list is displayed
    When I click on the first search result
    Then City weather page header contains city name "New York" from the search


