Feature: Login test
  #Agile story= The user should be able to login with valid credentials
  Background:
    Given The user is on the login page

  Scenario: Positive scenario 1
    When The user enters valid credentials
    Then The user verify welcome message
  @wip
    Scenario: Positive scenario 2
      When The user enters "metehanmar" and "12345mete" credential
      Then The user verify welcome "metehanmar" message

  @loginwithScenarioOutline
  Scenario Outline: Positive scenario 3
    When The user enters "<username>" and "<password>" credentials
    Then The user verify welcome "<username>" message
    Examples:
      | username  | password |
      | metehanmar | 12345mete |

  @loginwithDataTableAndScenarioOutline
  Scenario Outline: Positive scenario 4
    When The user enters valid username and password
      | user     | <username> |
      | password | <password> |
    Then The user verify welcome "<username>" message
    Examples:
      | username  | password |
      | metehanmar | 12345mete |