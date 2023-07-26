package test.api.tests;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import test.api.steps.user.UserApiSteps;
import test.ui.testdata.RandomData;
import test.ui.testdata.TestData;

public class ApiUserTests extends ApiTestInit{
    UserApiSteps userApiSteps = new UserApiSteps();
    private String userId;
    private Boolean resultAfterRemoveUser;
    private JsonPath result;
    private String resultUsername;
    private String resultUserId;
    private String resultEmail;
    private String USERNAME = RandomData.randomName();
    @Test(priority = 1)
    public void createUserApiTest(){
        userId = userApiSteps.createUser(USERNAME, TestData.PASSWORD);
        System.out.println(userId);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(userId, "UserId is null");
        softAssert.assertAll();
    }
    @Test(priority = 2)
    public void getUserApiTest(){
        result = userApiSteps.getUser(Integer.valueOf(userId));
        System.out.println(result);

        SoftAssert softAssert = new SoftAssert();
        resultUsername = result.getString("result.username");
        softAssert.assertEquals(resultUsername, USERNAME);

        resultUserId = result.getString("result.id");
        softAssert.assertEquals(resultUserId, userId);

        resultEmail = result.getString("result.email");
        softAssert.assertEquals(resultEmail, USERNAME+"@mail.com");

        softAssert.assertAll();
    }
    @Test(priority = 3)
    public void removeUserApiTest(){
        resultAfterRemoveUser = userApiSteps.deleteUser(Integer.valueOf(userId));
        System.out.println("resultAfterRemoveUser: " + resultAfterRemoveUser);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(resultAfterRemoveUser, "User delete false");
        softAssert.assertAll();
    }
}
