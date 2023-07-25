package test.api.tests;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import test.api.steps.project.ProjectApiSteps;
import test.api.steps.projectuser.ProjectUserApiSteps;
import test.api.steps.task.TaskApiSteps;
import test.api.steps.user.UserApiSteps;
import test.ui.testdata.TestData;

public class ApiTaskTests extends ApiTestInit{
    UserApiSteps userApiSteps = new UserApiSteps();
    ProjectApiSteps projectApiSteps = new ProjectApiSteps();
    ProjectUserApiSteps projectUserApiSteps = new ProjectUserApiSteps();
    TaskApiSteps taskApiSteps = new TaskApiSteps();
    private String userId;
    private String projectId;
    private String taskId;
    private JsonPath result;
    private String resultTaskTitle;
    private String resultTaskId;
    private String resultDescriptionId;
    private Boolean resultAfterRemoveUser;
    private Boolean resultAfterRemoveProject;
    private Boolean resultAfterRemoveTask;
    @Test(priority = 1)
    public void createTaskApiTest(){
        userId = userApiSteps.createUser(TestData.USERNAME, TestData.PASSWORD);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(userId, "UserId is null");

        projectId = projectApiSteps.createProject(TestData.projectNAME, Integer.valueOf(userId));
        System.out.println(projectId);
        softAssert.assertNotNull(projectId, "ProjectId is null");
        projectUserApiSteps.addProjectUser(Integer.valueOf(projectId), Integer.valueOf(userId));

        taskId = taskApiSteps.createTask(Integer.valueOf(projectId), Integer.valueOf(userId), TestData.taskDescription, TestData.taskTitle, TestData.taskColor);
        System.out.println(taskId);
//        softAssert.assertSame(taskId, "TaskId is null");

        softAssert.assertAll();
    }
    @Test(priority = 2)
    public void getTaskApiTest(){
        result = taskApiSteps.getTask(Integer.valueOf(taskId));
        System.out.println(result);

        SoftAssert softAssert = new SoftAssert();
        resultTaskTitle = result.getString("result.title");
        softAssert.assertEquals(resultTaskTitle, TestData.taskTitle);

        resultTaskId = result.getString("result.id");
        softAssert.assertEquals(resultTaskId, taskId);

        resultDescriptionId = result.getString("result.description");
        softAssert.assertEquals(resultDescriptionId, TestData.taskDescription);

        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void removeTaskApiTest(){
        resultAfterRemoveUser = userApiSteps.deleteUser(userId);
        System.out.println("resultAfterRemoveUser:" + resultAfterRemoveUser);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(resultAfterRemoveUser, "User remove false");

        resultAfterRemoveProject = projectApiSteps.removeProject(projectId);
        System.out.println("resultAfterRemoveProject:" + resultAfterRemoveProject);
        projectUserApiSteps.removeProjectUser(projectId, userId);

        resultAfterRemoveTask =taskApiSteps.removeTask(Integer.valueOf(taskId));
        System.out.println("resultAfterRemoveTask: " + resultAfterRemoveTask);

//        softAssert.assertTrue(resultAfterRemoveProject, "Task remove false");
        softAssert.assertAll();
    }
}
