Feature: Yandex Mail

  @mail
  Scenario: Send email to yourself
    Given 'https://mail.yandex.ru/' url is opened
    And I'm logged in as 'Mail' user
    When I create a new mail
    And I choose myself as a recipient
    And I type 'test' subject
    And I send a mail
    When I open Inbox folder
    Then new email with 'test' subject is displayed