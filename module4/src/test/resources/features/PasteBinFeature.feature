Feature: PasteBin

  @once
  Scenario: I can win
    Given 'https://paste.ubuntu.com' url is opened
    When I type "Hello from WebDriver" text in 'Content' textbox
    And I choose 'A day' Paste Expiration
    And I type "helloweb" text in 'Paste Name / Title' textbox
    And I press Create new paste button
    Then paste is posted

  Scenario: Bring it on
    Given 'https://paste.ubuntu.com' url is opened
    When I type "git config --global user.name "New Sheriff in Town"  git reset $(git commit-tree HEAD^{tree} -m "Legacy code")  git push origin master --force" text in 'Content' textbox
    And I choose 'A day' Paste Expiration
    And I choose 'Bash' Syntax Highlighting
    And I type "how to gain dominance among de" text in 'Paste Name / Title' textbox
    And I press Create new paste button
    Then paste is posted
    And page title is "how to gain dominance among de"
    And entered text is "git config --global user.name "New Sheriff in Town"  git reset $(git commit-tree HEAD^{tree} -m "Legacy code")  git push origin master --force"

  Scenario: Check expiration time
    Given 'https://paste.ubuntu.com' url is opened
    When I type "expiration" text in 'Content' textbox
    And I choose 'A day' Paste Expiration
    And I type "expiration" text in 'Paste Name / Title' textbox
    And I press Create new paste button
    Then paste is posted
    And paste expiration date is calculated correctly for 'A day' Paste Expiration