@github-api
Feature: GitHub API Test Suite

  Scenario: Create new GitHub repo
    Given I create a new GitHub repository named "Test-Repo"
    Then Server response code is 201
    And The response contains text "id"

  Scenario: Update previously created GitHub repository
    Given I update repo description for "Some generic description"
    Then Server response code is 200
    And The response contains text "Some generic description"

  Scenario: Delete previously created GitHub repository
    Given I delete repository
    Then Server response code is 204

  Scenario: Try to create a repo using invalid credentials
    Given I try to create a repo using invalid creds
    Then Server response code is 401
    And The response contains text "Bad credentials"