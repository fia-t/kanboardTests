package test.api.tests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import test.api.steps.user.UserApiSteps;
import test.ui.testdata.TestData;

import java.util.List;

public class ApiUserTests extends ApiTestInit{
    UserApiSteps userApiSteps = new UserApiSteps();
    private String userId;
    private Boolean resultAfterDeleteUser;
    @Test()
    public void createUserApiTest(){
        userId = userApiSteps.createUser(TestData.USERNAME, TestData.PASSWORD);
        System.out.println(userId);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(userId, "UserId is null");
        softAssert.assertAll();
    }
    @Test()
    public void removeUserApiTest(){
        resultAfterDeleteUser = userApiSteps.deleteUser(userId);
        System.out.println("!!!!!!!!!!!!!!!!!!!!!" + resultAfterDeleteUser);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(resultAfterDeleteUser, "User delete false");
        softAssert.assertAll();
    }
}
