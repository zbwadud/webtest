@${appName.toUpperCase()} @${appNameLC}-searchorganisation
Feature: ${appName} : Search Organisation
  As a NZQA user
  I want to maintain organisations details
  So that NZQA has up-to-date organisation details
  
  Scenario: Add an organisation
    Given I am a logged on ${appName} user
    When I search for the organisation 'te aroha'
    And I add a new organisation
    Then the organisation status is 'ACTIVE'
    Then the new organisation details are displayed

  Scenario: Edit an address
    When I search for the new organisation
    And I change the Address Line 2 to 'Testville' with the Reason 'Contact requested change'
    Then the updated organisation details are displayed

  Scenario: Add role type
    Given I search for the new organisation
    And there is no role type
    When I add a role type of 'Provider'
    Then there is a role type of 'Provider' from today's date
