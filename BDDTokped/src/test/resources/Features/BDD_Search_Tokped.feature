Feature: Feature test search tokopedia homepage
  User want to search Seblak on tokped homepage

  Scenario: Validate tokopedia searching is working
    Given User open browser
    And User on tokopedia homepage
    When User search seblak on search box
    Then User navigated to seblak result page