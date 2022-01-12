Feature: Check ten functions of the site
  As a user
  I want check the work of the site
  So that everything should be correct

  Scenario Outline: 1 Read the Ebay news
    Given User opens '<homePage>' page
    When User goes to news page
    Then User sees news list items

    Examples:
      | homePage              |
      | https://www.ebay.com/ |


  Scenario Outline: 2 Search in the search bar
    Given User opens '<homePage>' page
    And User enters into the search bar '<inputText>'
    And User presses Search button
    Then User sees at least one item in the list containing '<resultSearch>'

    Examples:
      | homePage              | inputText | resultSearch |
      | https://www.ebay.com/ | cucumber  | cucumber     |

  Scenario Outline: 3 To get a list of vacuum cleaners in the price range of $150-350 Xiaomi
    Given User opens '<homePage>' page
    And User presses Xiaomi button
    And User presses Vacuum cleaners button
    And User presses Price button
    And User selects a price range 150-350
    Then User checks prices in the range 150-350 '<designations>'

    Examples:
      | homePage              | designations |
      | https://www.ebay.com/ | $            |


  Scenario Outline: 4 To display the search results of vacuum cleaners list
    Given User opens '<homePage>' page
    And User presses Xiaomi button
    And User presses Vacuum cleaners button
    And User presses View button
    And User presses View as list button
    Then User sees a list of items

    Examples:
      | homePage              |
      | https://www.ebay.com/ |


  Scenario Outline: 5 Entering an incorrect username should generate an error message
    Given User opens '<homePage>' page
    And User presses Xiaomi button
    And User presses Vacuum cleaners button
    And User select first list item
    And User presses Add to Watchlist button
    And User inputs field '<UserName>'
    And User presses Continue button
    Then User sees Error message

    Examples:
      | homePage              | UserName |
      | https://www.ebay.com/ | Alex     |
      | https://www.ebay.com/ |          |

  Scenario Outline: 6 Checking the search when entering incorrect words
    Given User opens '<homePage>' page
    And User enters into the search bar '<inputText>'
    And User presses Search button
    Then User gets negative result

    Examples:
      | homePage              | inputText |
      | https://www.ebay.com/ | asfdsf    |

  Scenario Outline: 7 User enters incorrect mail
    Given User opens '<homePage>' page
    And User presses Xiaomi button
    And User presses Vacuum cleaners button
    And User select first list item
    And User click on number field
    When User inputs 0
    Then User sees Error message incorrect numbers

    Examples:
      | homePage              |
      | https://www.ebay.com/ |

  Scenario Outline: 8 Qualifying search
    Given User opens '<homePage>' page
    And User presses Xiaomi button
    And User presses Vacuum cleaners button
    And User enters vacuum cleaners in the search bar '<inputText>' and presses ENTER
    Then User checks list items contain '<resultSearch>'

    Examples:
      | homePage              | inputText | resultSearch |
      | https://www.ebay.com/ | vacuum    | Vacuum       |

  Scenario Outline: 9 Search Results - Search Filters - Using text in price range should show an error
    Given User opens '<homePage>' page
    And User enters into the search bar '<inputText>'
    And User presses Search button
    And User inputs minimum price '<inputPrice>'
    Then User sees an exception

    Examples:
      | homePage              | inputText | inputPrice |
      | https://www.ebay.com/ | cucumber  | asd        |

  Scenario Outline: 10 Search Results - Related - selecting related search query should perform new search
    Given User opens '<homePage>' page
    And User enters into the search bar '<inputText>'
    And User presses Search button
    And User selects '<relatedSearch>' check button
    Then User sees at least one item in the list containing '<resultSearch>'

    Examples:
      | homePage              | inputText | relatedSearch | resultSearch |
      | https://www.ebay.com/ | cucumber  | Tomato        | Tomato       |

#Scenario Outline: 11 User enters incorrect mail
#    Given User opens '<homePage>' page
#    And User presses Xiaomi button
#    And User presses Vacuum cleaners button
#    And User select first list item
#    And User presses Add to Watchlist button
#    And User presses Continue with Google button
#    And User inputs '<userMail>' mail
#    And User presses Next Button
#    And User presses Next Button
#    And User inputs '<userMail>' mail
#    And User presses Next Button
#    And User inputs '<userPassword>' password
#    And User presses Next Button
#    Then User sees Error message incorrect password
#
#  Examples:
#    | homePage              | userMail | userPassword |
#    | https://www.ebay.com/ | Alex     | Alex1        |
