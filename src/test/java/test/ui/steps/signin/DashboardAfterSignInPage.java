package test.ui.steps.signin;

import io.qameta.allure.Step;
import test.ui.elements.signing.DashboardAfterSignInElements;

import static com.codeborne.selenide.Condition.visible;

public class DashboardAfterSignInPage extends DashboardAfterSignInElements {

    @Step("Should Sign in")
    public String assertDashboardIsOpened() {
        dashboardMainSection().shouldBe(visible);
        return dashboardTitle().getText();
    }
    @Step("Should see message about error")
    public String assertMessage() {
        errorMessage().shouldBe(visible);
        return errorMessage().getText();
    }

}
