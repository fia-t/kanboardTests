package test.ui.tests.task.comments;

import jdk.jfr.Description;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import test.api.steps.project.ProjectApiSteps;
import test.api.steps.projectuser.ProjectUserApiSteps;
import test.api.steps.task.TaskApiSteps;
import test.api.steps.user.UserApiSteps;
import test.configuration.browserConfiguration;
import test.ui.steps.signin.SigninPage;
import test.ui.steps.task.TaskPage;
import test.ui.steps.task.ViewBoardPage;
import test.ui.testdata.RandomData;
import test.ui.testdata.TestData;
import test.ui.tests.BaseTest;

public class addCommentTaskTest extends BaseTest {
    UserApiSteps userApiSteps = new UserApiSteps();
    ProjectApiSteps projectApiSteps = new ProjectApiSteps();
    ProjectUserApiSteps projectUserApiSteps = new ProjectUserApiSteps();
    TaskApiSteps taskApiSteps = new TaskApiSteps();
    private String userId;
    private String projectId;
    private String taskId;
    private String USERNAME = RandomData.randomName();
    @BeforeMethod
    public void prepareDataForTest() {
        userId = userApiSteps.createUser(USERNAME, TestData.PASSWORD);
        System.out.println(userId);

        projectId = projectApiSteps.createProject(TestData.projectNAME, Integer.valueOf(userId));
        System.out.println(projectId);

        projectUserApiSteps.addProjectUser(Integer.valueOf(projectId), Integer.valueOf(userId));

        taskId = taskApiSteps.createTask(Integer.valueOf(projectId), Integer.valueOf(userId), TestData.taskDescription, TestData.taskTitle, TestData.taskColor);
        System.out.println(taskId);

    }

    @Description("The test is positive case for add comment to Task")
    @Test
    public void addCommentPositive(){

        String  dashboardAfterSignin  = new SigninPage()
                .openSigninPage()
                .signinByUser(USERNAME, TestData.PASSWORD)
                .assertDashboardIsOpened();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(dashboardAfterSignin, TestData.dashboardAfterSigninMessage +USERNAME, "User is not signin");

        ViewBoardPage addCommentTasks = new TaskPage()
                .addCommentForTasks(TestData.comment);

        softAssert.assertEquals(addCommentTasks.getCommentForTask(), TestData.comment, "Comment not equal");
        softAssert.assertEquals(addCommentTasks.getCommentForTaskUser(), USERNAME, "User not equal");

        softAssert.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void removeDataAfterTest() {
        userApiSteps.deleteUser(Integer.valueOf(userId));
        projectApiSteps.removeProject(projectId);
        projectUserApiSteps.removeProjectUser(projectId, userId);
        taskApiSteps.removeTask(Integer.valueOf(taskId));
    }
}
