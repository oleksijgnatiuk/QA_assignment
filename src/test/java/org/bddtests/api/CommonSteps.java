package org.bddtests.api;
import static org.assertj.core.api.Assertions.assertThat;
import static net.serenitybdd.rest.SerenityRest.lastResponse;
import cucumber.api.java.en.And;
import io.restassured.response.Response;
import cucumber.api.java.en.Then;


public class CommonSteps {

  @Then("Server response code is {int}")
  public void responseCodeIs(int responseCode) {
    Response lastResponse = lastResponse();
    assertThat(lastResponse.statusCode()).isEqualTo(responseCode);
  }

  @And("The response contains text {string}")
  public void verifyResponseContent(String msg_content){
    Response lastResponse = lastResponse();
    assertThat(lastResponse.getBody().asString()).containsIgnoringCase(msg_content);
  }
}