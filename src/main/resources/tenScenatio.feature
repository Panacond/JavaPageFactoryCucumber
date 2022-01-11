Feature: Check ten functions of the site
  As a user
  I want check the work of the site
  So that everything should be correct

  Scenario Outline: First read the news
    Given User go to '<home_page>'
    When User go to news page
    Then User see news list 8 items

    Examples:
      | home_page             |
      | https://www.ebay.com/ |


  Scenario Outline: Find second in the search bar
    Given User go to '<home_page>'
    And User enter into the search bar '<input_text>'
    And User press button search
    Then User sees at least one item in the list containing '<result_search>'

    Examples:
      | home_page             | input_text | result_search |
      | https://www.ebay.com/ | cucumber   | cucumber      |

  Scenario Outline: Third to get a list of vacuum cleaners in the price range of $150-350 Xiaomi
    Given User go to '<home_page>'
    And User press button Xiaomi
    And User press button vacuum cleaners
    And User press button price
    And User select a price range one hundred fifty to three hundred fifty
    Then User check prices are in the range one hundred fifty to three hundred fifty

    Examples:
      | home_page             |
      | https://www.ebay.com/ |


  Scenario Outline: Fourth to display the search results of vacuum cleaners list
    Given User go to '<home_page>'
    And User press button Xiaomi
    And User press button vacuum cleaners
    And User press button view
    And User press the button view as a list
    Then User sees a list of items

    Examples:
      | home_page             |
      | https://www.ebay.com/ |


  Scenario Outline: Fifth Add to Watchlist
    Given User go to '<home_page>'
    And User press button Xiaomi
    And User press button vacuum cleaners
    And User select first list item
    And User press button Add to Watchlist
    Then User view UserName

    Examples:
      | home_page             |
      | https://www.ebay.com/ |

  Scenario Outline: Sixth negative search
    Given User go to '<home_page>'
    And User enter into the search bar '<input_text>'
    And User press button search
    Then User get a negative result

    Examples:
      | home_page             | input_text |
      | https://www.ebay.com/ | asfdsf     |

  Scenario Outline: Seventh Refine Search Negative
    Given User go to '<home_page>'
    And User press button Xiaomi
    And User press button vacuum cleaners
    And User enter vacuum cleaners in the search bar '<input_text>' and press ENTER
    Then User get a negative result

    Examples:
      | home_page             | input_text |
      | https://www.ebay.com/ | ertyyrtey  |

  Scenario Outline: Eighth qualifying search
    Given User go to '<home_page>'
    And User press button Xiaomi
    And User press button vacuum cleaners
    And User enter vacuum cleaners in the search bar '<input_text>' and press ENTER
    Then check list items contain '<result_search>'

    Examples:
      | home_page             | input_text | result_search |
      | https://www.ebay.com/ | vacuum     | Vacuum        |

  Scenario Outline: Ninth price entry in letters negative
    Given User go to '<home_page>'
    And User enter into the search bar '<input_text>'
    And User press button search
    And User input price '<input_price>'
    Then User sees an exception

    Examples:
      | home_page             | input_text | input_price |
      | https://www.ebay.com/ | cucumber   | asd         |

  Scenario Outline: Tenth pick a cucumber and common name Tomato
    Given User go to '<home_page>'
    And User enter into the search bar '<input_text>'
    And User press button search
    And User select check button Tomato
    Then User sees at least one item in the list containing '<result_search>'

    Examples:
      | home_page             | input_text | result_search |
      | https://www.ebay.com/ | cucumber   | Tomato        |
