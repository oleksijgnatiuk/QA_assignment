package org.bddtests.api.steps;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.bddtests.common.CommonRequestSpec;

public class GitHubAPIActions {
    EnvironmentVariables env = SystemEnvironmentVariables.createEnvironmentVariables();
    String personalAccessToken = env.getProperty("access_token");

    private String accessToken = "token "+personalAccessToken;

    @Step ("Invoking GitHub create repository endpoint")
    public Response createNewGitHubRepository(String payload) {
        return SerenityRest.given().spec(CommonRequestSpec.basicSpec("CREATE_NEW_REPO"))
                .header("Authorization", accessToken)
                .body(payload)
                .post().then().extract().response();
    }
    @Step ("Invoking GitHub update repository endpoint")
    public Response updateGitHubRepository(String repoOwner, String repoName, String payload) {
        return SerenityRest.given().spec(CommonRequestSpec.basicSpec("CHANGE_REPO_STATE"))
        .header("Authorization", accessToken)
        .basePath(repoOwner+"/"+repoName)
        .body(payload)
        .patch().then().extract().response();
        }
    @Step ("Invoking GitHub delete repository endpoint")
    public Response deleteGitHubRepository(String repoOwner, String repoName) {
        return SerenityRest.given().spec(CommonRequestSpec.basicSpec("CHANGE_REPO_STATE"))
                .header("Authorization", accessToken)
                .basePath(repoOwner+"/"+repoName)
                .delete().then().extract().response();
    }
    @Step ("Invoking GitHub create repository endpoint using invalid creds")
    public Response createGitHubRepoUsingInvalidCreds(String payload) {
        return SerenityRest.given().spec(CommonRequestSpec.basicSpec("CREATE_NEW_REPO"))
                .header("Authorization", "token MPjl2Y5AkvtP30rFb3ABRwkYNWsuRhJXkRQLhjaweqsC7H4fg8H2UmY5RpOkbO05")
                .body(payload)
                .post().then().extract().response();
    }

    }