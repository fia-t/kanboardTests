package test.ui.tests.task.changeStatus;
import jdk.jfr.Description;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import test.api.steps.project.ProjectApiSteps;
import test.api.steps.projectuser.ProjectUserApiSteps;
import test.api.steps.task.TaskApiSteps;
import test.api.steps.user.UserApiSteps;
import test.ui.steps.signin.SigninPage;
import test.ui.steps.task.TaskPage;
import test.ui.steps.task.ViewBoardPage;
import test.ui.testdata.TestData;
import test.ui.tests.BaseTest;
import test.configuration.browserConfiguration;

public class closeTaskTest extends BaseTest {
    UserApiSteps userApiSteps = new UserApiSteps();
    ProjectApiSteps projectApiSteps = new ProjectApiSteps();
    ProjectUserApiSteps projectUserApiSteps = new ProjectUserApiSteps();
    TaskApiSteps taskApiSteps = new TaskApiSteps();
    private String userId;
    private String projectId;
    private String taskId;
    @BeforeMethod
    public void prepareDataForTest() {
        userId = userApiSteps.createUser(TestData.USERNAME, TestData.PASSWORD);
        System.out.println(userId);

        projectId = projectApiSteps.createProject(TestData.projectNAME, Integer.valueOf(userId));
        System.out.println(projectId);

        projectUserApiSteps.addProjectUser(Integer.valueOf(projectId), Integer.valueOf(userId));

        taskId = taskApiSteps.createTask(Integer.valueOf(projectId), Integer.valueOf(userId), TestData.taskDescription, TestData.taskTitle, TestData.taskColor);
        System.out.println(taskId);

    }

    @Description("The test is positive case for close Task")
    @Test(dataProvider = "browsers")
    public void closeTaskPositive(String browser){
        browserConfiguration.browserConfiguration(browser);
        String  dashboardAfterSignin  = new SigninPage()
                .openSigninPage()
                .signinByUser(TestData.USERNAME, TestData.PASSWORD)
                .assertDashboardIsOpened();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(dashboardAfterSignin, TestData.dashboardAfterSigninMessage +TestData.USERNAME, "User is not signin");

        new TaskPage().closeTask();

        ViewBoardPage filterClosedTasks = new TaskPage()
                .filterClosedTasks();

        softAssert.assertEquals(filterClosedTasks.getTaskStatusClosed(), TestData.taskStatusClose, "Status not equal");

        softAssert.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void removeDataAfterTest() {
        userApiSteps.deleteUser(userId);
        projectApiSteps.removeProject(projectId);
        projectUserApiSteps.removeProjectUser(projectId, userId);
        taskApiSteps.removeTask(taskId);
    }
}
