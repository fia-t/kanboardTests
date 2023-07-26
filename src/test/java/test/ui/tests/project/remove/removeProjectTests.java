package test.ui.tests.project.remove;

import jdk.jfr.Description;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import test.ui.steps.project.DashboardAfterRemoveProjectPage;
import test.ui.steps.project.ProjectPage;
import test.ui.steps.signin.SigninPage;
import test.ui.testdata.TestData;
import test.ui.tests.BaseTest;
import test.configuration.browserConfiguration;

public class removeProjectTests extends BaseTest {
    @Description("The test is positive case for remove project")
    @Test
    public void removeProjectPositive(){

        String  dashboardAfterSignin  = new SigninPage()
                .openSigninPage()
                .signinByUser(TestData.adminUSERNAME, TestData.adminPASSWORD)
                .assertDashboardIsOpened();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(dashboardAfterSignin, TestData.dashboardAfterSigninMessage +TestData.adminUSERNAME, "User is not signin");

        new ProjectPage().removeProject();

        DashboardAfterRemoveProjectPage searchProjectPage = new ProjectPage()
                .searchProject(TestData.adminUSERNAME);

        softAssert.assertEquals(searchProjectPage.dashboardAfterRemoveProjectPage(), TestData.noProjectTitle, "Incorrect text");
        softAssert.assertEquals(searchProjectPage.getNoProjectText(), TestData.noProjectMessage, "Incorrect text");

        softAssert.assertAll();
    }
}
