package test.ui.tests.project.create;

import jdk.jfr.Description;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import test.ui.steps.project.DashboardAfterCreateProjectPage;
import test.ui.steps.project.ProjectPage;
import test.ui.steps.signin.SigninPage;
import test.ui.testdata.TestData;
import test.ui.tests.BaseTest;
import test.configuration.browserConfiguration;

public class createProjectTests extends BaseTest {
    @Description("The test is positive case for create project")
    @Test
    public void createProjectPositive(){

        String  dashboardAfterSignin  = new SigninPage()
                .openSigninPage()
                .signinByUser(TestData.adminUSERNAME, TestData.adminPASSWORD)
                .assertDashboardIsOpened();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(dashboardAfterSignin, TestData.dashboardAfterSigninMessage +TestData.adminUSERNAME, "User is not signin");

        DashboardAfterCreateProjectPage projectPage = new ProjectPage()
                .createProject(TestData.projectNAME);

        softAssert.assertEquals(projectPage.dashboardAfterCreateProjectPage(), TestData.projectNAME, "Project was not created");
        softAssert.assertTrue(projectPage.isProjectOwnerTextVisible(), "Element projectOwnerText is not visible");
        softAssert.assertEquals(projectPage.getProjectOwnerText(), "Project owner: "+TestData.adminUSERNAME, "Incorrect project owner text");

        softAssert.assertAll();
    }

}
