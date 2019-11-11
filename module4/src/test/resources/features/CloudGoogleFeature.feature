Feature: Google Cloud

  Background:
    Given 'https://cloud.google.com/' url is opened
    And I click See all solutions button
    And I click 'Pricing' tab
    When I choose Calculators section
    Then Google Cloud Platform Pricing Calculator is opened

  Scenario: Hurt me plenty
    When I choose 'Compute Engine' calculator tab
    And I fill the form with data
    And I press 'Add to Estimate' button
    Then estimations are displayed
    And value matches between estimation and entered in form in field 'VM class'
    And value matches between estimation and entered in form in field 'Instance type'
    And value matches between estimation and entered in form in field 'Region'
    And value matches between estimation and entered in form in field 'local SSD'
    And value matches between estimation and entered in form in field 'Commitment term'
    And total sum is '1,082.77'

  Scenario: Hardcore
    When I choose 'Compute Engine' calculator tab
    And I fill the form with data
    And I press 'Add to Estimate' button
    Then estimations are displayed
    When I press 'Email Estimate' button
    Then Email Your Estimate window is displayed
    When I open 'https://10minutemail.com/' url in a new browser tab
    And I copy mail address
    And I press 'Send Email' button
    And I return to the '2' browser tab
    Then email with subject 'Google Cloud Platform Price Estimate' is displayed
    When I open email with subject 'Google Cloud Platform Price Estimate'
    Then Total Estimated Monthly Cost matches between email and calculator