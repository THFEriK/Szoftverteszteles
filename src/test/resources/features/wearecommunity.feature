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
    Then I see the "tag" dropdown menu on Articles Page
    And I type "DEI Awareness" in the dropdown search
    Then I see the checkbox menu
    And I select the "DEI Awareness" checkbox from the suggested results
    Then I see 2 card on Articles Page

  Scenario: Search for Articles with specific Community
    Given the communities portal is opened
    When I click the articles button
    And I click the Community filter
    Then I see the "community" dropdown menu on Articles Page
    And I type "EPAM Hungary Meets you!" in the dropdown search
    Then I see the checkbox menu
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

  Scenario: Search for events with specific Language
    Given the communities portal is opened
    When I click the events button
    And I click on the More Filters button on Events Page
    And I click on the Language button on Events Page
    Then I see the language checkbox menu on Events Page
    When I check the "Belarusian" language checkbox menu on Events Page
    Then I see the "WBC: Board Games Wroclaw" card on Events Page
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

  Scenario Outline: Filter articles by author
    Given the communities portal is opened
    When I click the articles button
    And I click the More Filters button on Articles Page
    Then I see the More Filters menu on Articles Page
    And I click on the Author button from the More Filters menu
    Then I see the Author dropdown menu on Articles Page
    When I type "<author>" in search on the Author dropdown menu on Articles Page
    Then I see the author checkbox menu on Articles Page
    When I check the first option on the author checkbox menu on Articles Page
    Then I see the "<card-title>" card on Articles Page
    And I see <count> results on Articles Page
    Examples:
      | author              | card-title                                          | count |
      | Adam Davidson       | Key Takeaways from Europe’s Biggest Data Conference | 1     |
      | Tatsiana Paulovich  | Docs Release Notes PI5 (10.2-10.7)                  | 1     |
      | Anna Mekhanova      | Global Accessibility Awareness Day 2022             | 2     |

  Scenario: Login prompt when liking an article
    Given the communities portal is opened
    When I click the articles button
    And I click on the heart icon on the first article card
    Then I see the login window

  Scenario: Login prompt when saving an article to collection
    Given the communities portal is opened
    When I click the articles button
    And I click on the bookmark icon on the first article card
    Then I see the login window

    Scenario: Search for events with specific Speaker
      Given the communities portal is opened
      When I click the events button
      And I click on the More Filters button on Events Page
      And I click on the Speaker button on Events Page
      Then I see the speaker dropdown menu on Events Page
      When I type "Denis Stuk" in search on the Speaker dropdown menu on Events Page
      Then I see the speaker checkbox menu on Events Page
      When I check the first option on the speaker checkbox menu on Events Page
      Then I see the "JS CC Week #5" card on Events Page
      And I see 1 card on Events Page

