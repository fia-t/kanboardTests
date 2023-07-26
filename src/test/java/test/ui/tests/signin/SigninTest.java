package test.ui.tests.signin;

import jdk.jfr.Description;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import test.ui.steps.signin.SigninPage;
import test.ui.tests.BaseTest;
import test.ui.testdata.TestData;

public class SigninTest extends BaseTest {
    @Description("The test is positive case for Sign In to system as user")
//    @Test(dataProvider = "browsers")
    @Test
    public void signInPositive(){

//        browserConfiguration.setBrowserConfiguration(browser);

        String  dashboardAfterSignin  = new SigninPage()
                .openSigninPage()
                .signinByUser(TestData.adminUSERNAME, TestData.adminPASSWORD)
                .assertDashboardIsOpened();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(dashboardAfterSignin, TestData.dashboardAfterSigninMessage +TestData.adminUSERNAME, "User is not signin");
        softAssert.assertAll();
    }

    @Description("The test is negative case for Sign In to system")
//    @Test(dataProvider = "browsers")
    @Test
    public void signInNegative(){
//        browserConfiguration.setBrowserConfiguration(browser);
        String messageActual = new SigninPage()
                .openSigninPage()
                .signinByUser(TestData.username, TestData.password)
                .assertMessage();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(messageActual, TestData.errorMessage, "User is signin");
        softAssert.assertAll();
    }
}
