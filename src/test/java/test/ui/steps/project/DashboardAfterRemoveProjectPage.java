package test.ui.steps.project;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import test.ui.elements.signing.DashboardAfterSignInElements;

import static com.codeborne.selenide.Condition.visible;

public class DashboardAfterRemoveProjectPage extends DashboardAfterSignInElements {
    @Step("Title after remove project")
    public String dashboardAfterRemoveProjectPage() {
        return dashboardTitle().getText();
    }
    @Step("Get no project text")
    public String getNoProjectText() {
        return noProjectText().getText();
    }
}
