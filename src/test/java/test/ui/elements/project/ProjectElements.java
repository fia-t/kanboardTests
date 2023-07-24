package test.ui.elements.project;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ProjectElements {
    public SelenideElement newProject() {return $(".page-header > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)");}
    public SelenideElement nameProject() {return $("#form-name");}
    public SelenideElement btnSaveProject() {
        return $("button.btn");
    }
    public SelenideElement btnRemoveProject() {
        return $("li:nth-child(18) a.js-modal-confirm");
    }
    public SelenideElement btnYesRemoveProject() {
        return $("#modal-confirm-button");
    }
    public static SelenideElement dropdownMenu() {return $(".table-border-left > div:nth-child(1) > div:nth-child(1) > a:nth-child(1)");}
    public static SelenideElement configureProject() {return $(".dropdown-submenu-open > li:nth-child(5) > a:nth-child(1)");}
    public static SelenideElement viewBoard() {return $(".view-board");}
    public static SelenideElement viewList() {return $(".view-listing");}


}
