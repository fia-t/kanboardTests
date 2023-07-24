package test.ui.elements.signing;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class DashboardAfterSignInElements {
    public SelenideElement dashboardMainSection() {
        return $("#main");
    }
    public SelenideElement errorMessage() {
        return $(".alert");
    }
    public SelenideElement dashboardTitle() {return $(".title");}
    public SelenideElement projectOwnerText(){return $(".panel > li:nth-child(2)");}
    public SelenideElement noProjectText(){return $("p.alert");}
    public static SelenideElement searchField(){return $("#form-search");}



}
