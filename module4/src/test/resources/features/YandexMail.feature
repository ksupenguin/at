Feature: Yandex Mail

  @mail
  Scenario Outline: Send email to yourself
    Given 'https://mail.yandex.ru/' url is opened
    And I'm logged in as '<user>' user
    When I create a new mail
    And I choose myself as a recipient
    And I type 'test' subject
    And I send a mail
    When I open Inbox folder
    Then new email with 'test' subject is displayed

    Examples:
      | user  |
      | Mail  |
      | Mail2 |