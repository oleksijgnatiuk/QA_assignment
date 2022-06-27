package org.bddtests.common;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.guice.Injectors;
import net.thucydides.core.util.EnvironmentVariables;

public class CommonRequestSpec {


  public static RequestSpecification basicSpec(String baseURLPropertyKey) {
    EnvironmentVariables environmentVariables = Injectors.getInjector()
        .getInstance(EnvironmentVariables.class);

    String baseUrl = EnvironmentSpecificConfiguration.from(environmentVariables)
        .getProperty(String.format(baseURLPropertyKey));

    return new RequestSpecBuilder().setBaseUri(baseUrl)
        .setContentType("application/json")
        .addHeader("Accept", "application/vnd.github.v3+json")
        .build();
  }
}
