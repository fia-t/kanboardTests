package test.ui.steps.userSettings;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import test.ui.elements.userSettings.userSettingsElements;
import test.ui.elements.signing.SigninElements;

import static com.codeborne.selenide.Condition.visible;

public class settingsApiDashboardPage extends userSettingsElements {

    @Step("Go to user`s settings and see API token")
    public String getApiToken() {
        dropDownMenuAvatar().shouldBe(visible).click();
        menuSettings().shouldBe(visible).click();
        apiMenu().shouldBe(visible).click();
        apiToken().shouldBe(visible);
        return apiToken().getText();
    }

    @Step("Go to user`s settings and see API token")
    public SelenideElement logout() {
        dropDownMenuAvatar().shouldBe(visible).click();
        menuLogout().shouldBe(visible).click();
        return SigninElements.userField().shouldBe(visible);
    }

}
