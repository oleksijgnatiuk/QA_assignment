package org.bddtests.api;
import cucumber.api.java.en.Given;
import gherkin.deps.com.google.gson.JsonObject;
import net.thucydides.core.annotations.Steps;
import org.bddtests.api.steps.GitHubAPIActions;

import static net.serenitybdd.rest.SerenityRest.lastResponse;

public class GitHubAPI {

    @Steps
    private GitHubAPIActions GitHubAPIActions;

    @Given("I create a new GitHub repository named {string}")
        public void createGitHubRepository(String repoName) {
        JsonObject addNewRepoPayload = new JsonObject();
        addNewRepoPayload.addProperty("name", repoName);
        GitHubAPIActions.createNewGitHubRepository(addNewRepoPayload.toString());
        }
    @Given("I update repo description for {string}")
    public void updateRepoDesc(String repoDescription) {
        JsonObject updateRepoDesc = new JsonObject();
        updateRepoDesc.addProperty("description", repoDescription);
        String repoOwner = lastResponse().jsonPath().get("owner.login");
        String repoName = lastResponse().jsonPath().get("name");
        GitHubAPIActions.updateGitHubRepository(repoOwner, repoName, updateRepoDesc.toString());
    }
    @Given("I delete repository")
    public void deleteRepo() {
        String repoOwner = lastResponse().jsonPath().get("owner.login");
        String repoName = lastResponse().jsonPath().get("name");
        GitHubAPIActions.deleteGitHubRepository(repoOwner, repoName);
    }
    @Given("I try to create a repo using invalid creds")
    public void createRepoUsingInvalidCreds() {
        JsonObject addNewRepoPayload = new JsonObject();
        addNewRepoPayload.addProperty("name", "Test");
        GitHubAPIActions.createGitHubRepoUsingInvalidCreds(addNewRepoPayload.toString());
    }

    }
