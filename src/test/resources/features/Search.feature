@searchPage
Feature: Search for accommodations

  Scenario Outline: search for accommodations in a specific location

    Given the user is on the homepage
   # And the user is on the search page
    When the user enters "<location>" in the search bar
    And selects "<check-in-date>" as the check-in date
    #And selects "<check-out-date>" as the check-out date
    #And selects "<number-of-guests>" as the number of guests
    #And clicks on the search button
   # Then the user should see a list of available accommodations in "<location>"
    Examples:
      | location | check-in-date | check-out-date | number-of-guests |
    |Ooty|2023-10-01|2023-10-05|5|