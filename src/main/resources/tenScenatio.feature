Feature: Check ten functions of the site
  As a user
  I want check the work of the site
  So that everything should be correct

  Scenario Outline: 1 Check the Ebay news page visibility
    Given User opens '<homePage>' page
    When User clicks ‘news’ button
    Then User check news list items visibility

    Examples:
      | homePage              |
      | https://www.ebay.com/ |


  Scenario Outline: 2 Check keyword in results search list visibility
    Given User opens '<homePage>' page
    When User makes search by keyword '<inputText>'
    And User clicks ‘Search’ button
    Then User checks that each item in results list contains keyword '<resultSearch>' visible

    Examples:
      | homePage              | inputText | resultSearch |
      | https://www.ebay.com/ | cucumber  | cucumber     |

  Scenario Outline: 3 Check a list of vacuum cleaners in the price range of $150-350 Xiaomi
    Given User opens '<homePage>' page
    And User clicks ‘Xiaomi’ button
    And User clicks ‘Vacuum cleaners’ button
    When User clicks ‘Price’ button
    And User selects a price range 150-350
    Then User checks prices in the range 150-350 '<designations>'

    Examples:
      | homePage              | designations |
      | https://www.ebay.com/ | $            |


  Scenario Outline: 4 Check change view of the search results of vacuum cleaners list
    Given User opens '<homePage>' page
    And User clicks ‘Xiaomi’ button
    And User clicks ‘Vacuum cleaners’ button
    And User clicks 'View’ button
    When User clicks ‘List view’ button
    Then User check view change a list of items visibility

    Examples:
      | homePage              |
      | https://www.ebay.com/ |


  Scenario Outline: 5 Check that the incorrect username makes an error message visible
    Given User opens '<homePage>' page
    And User clicks ‘Xiaomi’ button
    And User clicks ‘Vacuum cleaners’ button
    And User clicks first list item
    And User clicks ‘Add to Watchlist’ button
    When User types '<UserName>' in input field
    And User clicks ‘Continue’ button
    Then User checks Error message

    Examples:
      | homePage              | UserName |
      | https://www.ebay.com/ | Alex     |
      | https://www.ebay.com/ |          |

  Scenario Outline: 6 Check that an incorrect search makes message ‘No exact matches found’ visible
    Given User opens '<homePage>' page
    When User makes search by keyword '<inputText>'
    And User clicks ‘Search’ button
    Then User checks that message No exact matches found visible

    Examples:
      | homePage              | inputText |
      | https://www.ebay.com/ | asfdsf    |

  Scenario Outline: 7 Check that an incorrect quantity makes message ‘Please enter quantity of 1 or more’ visible
    Given User opens '<homePage>' page
    And User clicks ‘Xiaomi’ button
    And User clicks ‘Vacuum cleaners’ button
    And User clicks first list item
    When User clicks ‘Quantity’ field
    And User inputs value 0
    Then User checks message ‘Please enter quantity of 1 or more’ visibility

    Examples:
      | homePage              |
      | https://www.ebay.com/ |

  Scenario Outline: 8 Check keyword in results search list on Vacuum cleaners page
    Given User opens '<homePage>' page
    And User clicks ‘Xiaomi’ button
    And User clicks ‘Vacuum cleaners’ button
    When User makes search by keyword '<inputText>' and presses ENTER in Vacuum cleaners page
    Then User checks list items contain '<resultSearch>'

    Examples:
      | homePage              | inputText | resultSearch |
      | https://www.ebay.com/ | vacuum    | Vacuum       |

  Scenario Outline: 9 Check error message ‘Please provide a valid price range’ when type text in price range
    Given User opens '<homePage>' page
    And User makes search by keyword '<inputText>'
    And User clicks ‘Search’ button
    When User inputs text '<inputPrice>' in minimum price field
    Then User checks that message ‘Please provide a valid price range’ visible

    Examples:
      | homePage              | inputText | inputPrice |
      | https://www.ebay.com/ | cucumber  | asd        |

  Scenario Outline: 10 Check selected keyword in results search list visibility
    Given User opens '<homePage>' page
    And User makes search by keyword '<inputText>'
    And User clicks ‘Search’ button
    And User clicks '<relatedSearch>' select button
    Then User checks that each item in results list contains keyword '<resultSearch>' visible

    Examples:
      | homePage              | inputText | relatedSearch | resultSearch |
      | https://www.ebay.com/ | cucumber  | Tomato        | Tomato       |
