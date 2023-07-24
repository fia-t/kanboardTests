package test.ui.tests.task.create;

import jdk.jfr.Description;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import test.api.steps.project.ProjectApiSteps;
import test.api.steps.projectuser.ProjectUserApiSteps;
import test.api.steps.user.UserApiSteps;
import test.ui.steps.signin.SigninPage;
import test.ui.steps.task.TaskPage;
import test.ui.steps.task.ViewBoardPage;
import test.ui.testdata.TestData;
import test.ui.tests.BaseTest;
import test.configuration.browserConfiguration;

public class createTaskTests extends BaseTest {
    UserApiSteps userApiSteps = new UserApiSteps();
    ProjectApiSteps projectApiSteps = new ProjectApiSteps();
    ProjectUserApiSteps projectUserApiSteps = new ProjectUserApiSteps();
    private String userId;
    private String projectId;
    @BeforeClass
    public void prepareDataForTest() {
        userId = userApiSteps.createUser(TestData.USERNAME, TestData.PASSWORD);
        System.out.println(userId);
        projectId = projectApiSteps.createProject(TestData.projectNAME, Integer.valueOf(userId));
        System.out.println(projectId);
        projectUserApiSteps.addProjectUser(Integer.valueOf(projectId), Integer.valueOf(userId));

    }

    @Description("The test is positive case for create Task")
    @Test(dataProvider = "browsers")
    public void createTaskPositive(String browser){
        browserConfiguration.browserConfiguration(browser);

        String  dashboardAfterSignin  = new SigninPage()
                .openSigninPage()
                .signinByUser(TestData.USERNAME, TestData.PASSWORD)
                .assertDashboardIsOpened();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(dashboardAfterSignin, TestData.dashboardAfterSigninMessage +TestData.USERNAME, "User is not signin");

        ViewBoardPage boardPage = new TaskPage().createTask(TestData.taskTitle);

        softAssert.assertEquals(boardPage.getTaskBoardTitleText(), TestData.taskTitle, "Task was not created");

        ViewBoardPage taskDetailPage = new TaskPage()
                .goToTaskFromBoard();

        softAssert.assertTrue(taskDetailPage.isTaskDetailTitleTextVisible(), "Element TaskBoardTitle is not visible");
        softAssert.assertTrue(taskDetailPage.isTaskDetailCreatorTextVisible(), "Element TaskBoardTitle is not visible");
        softAssert.assertEquals(taskDetailPage.getTaskStatusOpen(), TestData.taskStatusOpen, "Status not equal");
        softAssert.assertEquals(taskDetailPage.getTaskDetailTitleText(), TestData.taskTitle, "Project was not created");
        softAssert.assertEquals(taskDetailPage.getTaskDetailCreatorText(), TestData.USERNAME, "Project was not created");

        softAssert.assertAll();
    }

    @AfterClass(alwaysRun = true)
    public void removeDataAfterTest() {
        userApiSteps.deleteUser(userId);
        projectApiSteps.removeProject(projectId);
        projectUserApiSteps.removeProjectUser(projectId, userId);
    }

}
