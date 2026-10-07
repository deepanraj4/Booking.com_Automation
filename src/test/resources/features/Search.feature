@searchPage
Feature: Search for accommodations

  Scenario Outline: search for accommodations in a specific location

    Given the user is on the homepage
   # And the user is on the search page
    When the user enters "<location>" in the search bar
    And selects "<checkindate>" as the check-in date
    And selects "<checkoutdate>" as the check-out date
    And selects "<numberofguest>" as the number of guests
    And selects "<numberofrooms>" as the number of rooms
    And clicks on the search button
   # Then the user should see a list of available accommodations in "<location>"
    Examples:
      | location | checkindate | checkoutdate | numberofguest |numberofrooms|
    |Ooty|2026-11-05|2026-11-07|3|2|