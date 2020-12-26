Feature: Feature to test tokopedia Register page
  I want to register tokopedia

  Scenario: Validate register tokopedia is working
    Given User open browsers
    And User on tokopedia register page
    When User enter email or phone number
    And Click Daftar button and confirmation
    Then User navigated to select verify methode
