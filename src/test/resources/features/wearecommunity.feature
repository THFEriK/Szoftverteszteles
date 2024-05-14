Feature: Wearecommunity page

  Scenario Outline: Search for communities
    Given the communities portal is opened
    When I click the communities button
    And I type "<search-term>" in search
    Then I see the "<card-title>" card
    And I see <count> card
    Examples:
      | search-term | card-title                   | count |
      | Idea Pool   | Idea Pool                    | 1     |
      | Java        | JavaScript Competency Center | 12    |


  Scenario: Search for Event
    Given the communities portal is opened
    When I click the events button
    And I type "Latvian Speak" in search on Events Page
    Then I see the "Latvian Speaking club May 2024" card on Events Page
    And I see 1 card on Events Page


  Scenario: Search for Articles
    Given the communities portal is opened
    When I click the articles button
    And I type "A short story of Testing" in search on Articles Page
    Then I see the "A short story of Testing Community Poland" card on Articles Page
    And I see 1 card on Articles Page

  Scenario: Sort elements
    Given the communities portal is opened
    When I click the communities button
    And I click the Sort by button
    Then I see the dropdown menu
    When I click the A - Z button
    Then the cards should be in alphabetic order

  Scenario: Changing languages
    Given the communities portal is opened
    When I click the eng button
    Then I see the language dropdown menu
    When I click the Русский button
    Then The site language should be russian
