package test.api.steps;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import test.api.requests.BodyArgs;

import static utils.EnvProperties.*;

public class BaseApiSteps {

    public Response postRequest(String username, String token, BodyArgs bodyArgs) {

        return RestAssured.given()
                .contentType("application/json")
                .auth().basic(username, token)
                .body(bodyArgs).log().all()
                .when()
                .post(API_URL);
    }
}
