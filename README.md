# BDD Automated tests


## Tech stack
* Java/ JDK 12
* Serenity
* RestAssured lib
* Maven 3.8.6
* Cucumber

## Test execution using command line/ console

Apache Maven commands:


* `mvn clean verify -Daccess_token={access_token_value}` execute all test cases on default environment (QA)
* `mvn clean verify -Dcucumber.options="--tags @tag_name" -Daccess_token={access_token_value}` execute test cases with declared tag name against default env
* `mvn clean verify -Denvironment=environment_name -Daccess_token={access_token_value}` execute tests against the specific environment (dev/ qa/ stage/ prod)

#### note
For the GitHub personal access token, the following scopes are required `public_repo` and `delete_repo`


## HTML Report
* After successful test execution, the Serenity report could be reached from the following location: 
  `\target\site\serenity\index.html`"# QA_assignment" 
