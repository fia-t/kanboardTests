package test.ui.steps.project;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import test.ui.elements.signing.DashboardAfterSignInElements;

import static com.codeborne.selenide.Condition.visible;

public class DashboardAfterCreateProjectPage extends DashboardAfterSignInElements {
    @Step("Title after create project")
    public String dashboardAfterCreateProjectPage() {
        Configuration.timeout = 10000;
        dashboardMainSection().shouldBe(visible);
        return dashboardTitle().getText();
    }
    @Step("Is project owner text visible")
    public boolean isProjectOwnerTextVisible() {
        return projectOwnerText().is(visible);
    }

    @Step("Get project owner text")
    public String getProjectOwnerText() {
        return projectOwnerText().getText();
    }
}
