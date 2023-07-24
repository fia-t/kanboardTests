package test.ui.steps.project;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import test.ui.elements.project.ProjectElements;
import test.ui.elements.signing.DashboardAfterSignInElements;
import test.ui.steps.task.TaskPage;
import test.ui.testdata.TestData;

import static com.codeborne.selenide.Condition.visible;

public class ProjectPage extends ProjectElements {
    @Step("go to Project")
    public static ProjectPage goToProject() {
        Configuration.timeout = 10000;
        dropdownMenu().shouldBe(visible).click();
        configureProject().shouldBe(visible).click();
        viewBoard().shouldBe(visible);
        return new ProjectPage();
    }
    public DashboardAfterCreateProjectPage createProject(String projectName) {
        Configuration.timeout = 10000;
        newProject().shouldBe(visible).click();
        nameProject().shouldBe(visible).sendKeys(projectName);
        btnSaveProject().click();
        btnRemoveProject().shouldBe(visible);
        return new DashboardAfterCreateProjectPage();
    }
    public DashboardAfterRemoveProjectPage removeProject() {
        Configuration.timeout = 10000;
        goToProject();
        btnRemoveProject().shouldBe(visible).click();
        btnYesRemoveProject().shouldBe(visible).click();
        return new DashboardAfterRemoveProjectPage();
    }
    public DashboardAfterRemoveProjectPage searchProject(String userName) {
        Configuration.timeout = 10000;
        DashboardAfterSignInElements.searchField().shouldBe(visible).sendKeys(userName);
        DashboardAfterSignInElements.searchField().sendKeys(Keys.ENTER);
        return new DashboardAfterRemoveProjectPage();
    }
}
