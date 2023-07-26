package test.ui.steps.signin;

import io.qameta.allure.Step;
import test.ui.elements.signing.SigninElements;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class SigninPage extends SigninElements {
    @Step("open Signin Page")
    public SigninPage openSigninPage() {
        open("");
        return new SigninPage();
    }
    @Step("signin By User")
    public DashboardAfterSignInPage signinByUser(String username, String password) {
        userField().shouldBe(visible).sendKeys(username);
        passwordField().sendKeys(password);
        submitButton().click();
        return new DashboardAfterSignInPage();
    }
}
