Feature: Feature to test pulsa payment


  Scenario: Validate pulsa payment is working
    Given User open browserr
    And User on the tokopedia homepage
    When User input phone number on pulsa top up and tagihan
    And User select nominal
    And Click beli button
    Then User navigated to pulsa payment method
