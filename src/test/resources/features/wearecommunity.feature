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

  Scenario: Changing between upcoming and past events
    Given the communities portal is opened
    When I click the events button
    And I click the past events button
    Then I see the past events
    When I click the upcoming events button
    Then I see the upcoming events

  Scenario: Search for Articles with specific Tag
    Given the communities portal is opened
    When I click the articles button
    And I click the Tag filter
    And I type "DEI Awareness" in the dropdown search
    And I select the "DEI Awareness" checkbox from the suggested results
    Then I see 2 card on Articles Page

  Scenario: Search for Articles with specific Community
    Given the communities portal is opened
    When I click the articles button
    And I click the Community filter
    And I type "EPAM Hungary Meets you!" in the dropdown search
    And I select the "EPAM Hungary Meets you!" checkbox from the suggested results
    Then I see all the card's community names are "EPAM Hungary Meets you!"

  Scenario: Changing languages
    Given the communities portal is opened
    When I click the eng button
    Then I see the language dropdown menu
    When I click the Русский button
    Then The site language should be russian

    Scenario: Filter communities by tag
      Given the communities portal is opened
      When I click the communities button
      And I click on the Tag button
      Then I see the tag dropdown menu
      When I type "EventKit" in search on Tag dropdown
      Then I see the checkbox menu
      When I check the first option on the checkbox menu
      Then I see the "COMMUNITY DAY" card on Communities page
      And I see 1 card

    Scenario: Search for events with specific Location
      Given the communities portal is opened
      When I click the events button
      And I click on the Location button
      Then I see the location dropdown menu on Events Page
      When I type "Hungary" in search on the Location dropdown menu on Events Page
      Then I see the location checkbox menu on Events Page
      When I check the first option on the location checkbox menu on Events Page
      Then I see the "Coolest Projects Hungary 2024. tavasz" card on Events Page
      And I see 1 card on Events Page

  Scenario Outline: Filter articles by language
    Given the communities portal is opened
    When I click the articles button
    And I click the More Filters button on Articles Page
    Then I see the More Filters menu on Articles Page
    And I click on the Language button from the More Filters menu
    Then I see the language dropdown menu on Articles Page
    When I select the "<language>" checkbox from the dropdown menu
    Then I see the "<card-title>" card on Articles Page
    And I see <count> results on Articles Page
    Examples:
      | language  | card-title                               | count |
      | English   | How To Drive Backlog Refinement Sessions | 1370  |
      | Hungarian | Anyák napi különkiadás - gondolatok három EPAM-os édesanyától | 131   |
      | German    | Amöbe, TPS, Scrum und XP                 | 2     |

