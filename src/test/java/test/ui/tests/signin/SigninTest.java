package test.ui.tests.signin;

import com.codeborne.selenide.Configuration;
import jdk.jfr.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import test.api.steps.user.UserApiSteps;
import test.ui.steps.signin.SigninPage;
import test.ui.tests.BaseTest;
import test.ui.testdata.TestData;
import test.configuration.browserConfiguration;

public class SigninTest extends BaseTest {
    UserApiSteps userApiSteps = new UserApiSteps();
    private String userId;

    @BeforeMethod
    public void prepareDataForTest() {
        userId = userApiSteps.createUser(TestData.USERNAME, TestData.PASSWORD);
        System.out.println(userId);
    }

    @Description("The test is positive case for Sign In to system as user")
    @Test(dataProvider = "browsers")
    public void signInPositive(String browser){

        browserConfiguration.browserConfiguration(browser);

        String  dashboardAfterSignin  = new SigninPage()
                .openSigninPage()
                .signinByUser(TestData.adminUSERNAME, TestData.adminPASSWORD)
                .assertDashboardIsOpened();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(dashboardAfterSignin, TestData.dashboardAfterSigninMessage +TestData.adminUSERNAME, "User is not signin");
        softAssert.assertAll();
    }

    @Description("The test is negative case for Sign In to system")
    @Test(dataProvider = "browsers")
    public void signInNegative(String browser){
        browserConfiguration.browserConfiguration(browser);
        String messageActual = new SigninPage()
                .openSigninPage()
                .signinByUser(TestData.username, TestData.password)
                .assertMessage();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(messageActual, TestData.errorMessage, "User is signin");
        softAssert.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void removeUserAfterTest() {
        userApiSteps.deleteUser(userId);
    }
}
