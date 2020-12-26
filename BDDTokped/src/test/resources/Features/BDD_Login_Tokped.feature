Feature: Feature test tokopedia login page
  User want to login successfully

  Scenario: Validate tokopedia login is working
    Given User open the browser
    And User on tokopedia login page
    When User enter valid email or phone number
    And Click Selanjutnya button
    And User enter valid password
    And Click Login button
    Then User navigated to verify with phone number or email
