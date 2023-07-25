package test.api.tests;

import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import test.api.steps.project.ProjectApiSteps;
import test.api.steps.user.UserApiSteps;
import test.ui.testdata.TestData;

public class ApiProjectTests extends ApiTestInit{
    UserApiSteps userApiSteps = new UserApiSteps();
    ProjectApiSteps projectApiSteps = new ProjectApiSteps();
    private String userId;
    private String projectId;
    private Boolean resultAfterRemoveUser;
    private Boolean resultAfterRemoveProject;
    private JsonPath result;
    private String resultProjectName;
    private String resultProjectId;
    @Test(priority = 1)
    public void createProjectApiTest(){
        userId = userApiSteps.createUser(TestData.USERNAME, TestData.PASSWORD);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotNull(userId, "UserId is null");

        projectId = projectApiSteps.createProject(TestData.projectNAME, Integer.valueOf(userId));
        System.out.println(projectId);
        softAssert.assertNotNull(projectId, "ProjectId is null");
        softAssert.assertAll();
    }
    @Test(priority = 2)
    public void getProjectApiTest(){
        result = projectApiSteps.getProject(Integer.valueOf(projectId));
        System.out.println(result);

        SoftAssert softAssert = new SoftAssert();
        resultProjectName = result.getString("result.name");
        softAssert.assertEquals(resultProjectName, TestData.projectNAME);

        resultProjectId = result.getString("result.id");
        softAssert.assertEquals(resultProjectId, projectId);

        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void removeProjectApiTest(){
        resultAfterRemoveUser = userApiSteps.deleteUser(userId);
        System.out.println("resultAfterRemoveUser: " + resultAfterRemoveUser);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(resultAfterRemoveUser, "User remove false");

        resultAfterRemoveProject = projectApiSteps.removeProject(projectId);
        System.out.println("resultAfterRemoveProject: " + resultAfterRemoveProject);

        softAssert.assertTrue(resultAfterRemoveProject, "Project remove false");
        softAssert.assertAll();
    }
}
