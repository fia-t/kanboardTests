package test.api.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import test.api.steps.user.UserApiSteps;
import test.ui.testdata.TestData;

public class ApiUserTests extends ApiTestInit{
    UserApiSteps userApiSteps = new UserApiSteps();
    private String userId;
    private Boolean resultAfterRemoveUser;
    @Test()
    public void createUserApiTest(){
        userId = userApiSteps.createUser(TestData.USERNAME, TestData.PASSWORD);
        System.out.println(userId);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(userId, "UserId is null");
        softAssert.assertAll();
    }
    @Test(dependsOnMethods = "createUserApiTest")
    public void removeUserApiTest(){
        resultAfterRemoveUser = userApiSteps.deleteUser(userId);
        System.out.println("resultAfterRemoveUser: " + resultAfterRemoveUser);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(resultAfterRemoveUser, "User delete false");
        softAssert.assertAll();
    }
}
