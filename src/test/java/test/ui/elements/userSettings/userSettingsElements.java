package test.ui.elements.userSettings;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class userSettingsElements {
    public SelenideElement apiToken() {return $(".panel li:nth-child(1) strong");}

    public SelenideElement dropDownMenuAvatar() {
        return $("div.dropdown:nth-child(3) > a:nth-child(1)");
    }

    public SelenideElement menuSettings() {
        return $(".dropdown-submenu-open > li:nth-child(8) > a");
    }
    public SelenideElement apiMenu() {
        return $(".sidebar > ul:nth-child(1) > li:nth-child(11) > a:nth-child(1)");
    }
    public SelenideElement menuLogout() {
        return $(" .dropdown-submenu-open li:nth-child(10) a");
    }


}
