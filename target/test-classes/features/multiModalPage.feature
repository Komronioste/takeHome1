@regression
Feature: W3 Test

  Background: 
    Given Go to standards

  @modal
  Scenario: Multimodal Access Extension Test
    When click on web of devices tab
    And click on multimodal access tab
    Then validate multimodal access header is present

  @htmlcss
  Scenario: HTMLCSS Extension Test
    When click on web design button
    And click on htmlcss tab
    Then I validate htmlcss header is present

  @standards
  Scenario: Test all links on Standards page
    When collect all links
    Then check all links
    
    @badpage
    Scenario: Test bad page
    When go to badpage
    Then validate status code is 404
    
