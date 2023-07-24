package test.ui.elements.task;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class TaskElements {

    public SelenideElement addTaskBacklog() {return $("th.board-column-header:nth-child(1) > div:nth-child(2) > div:nth-child(1) > a:nth-child(1)");}
    public SelenideElement titleTask() {return $("#form-title");}
    public SelenideElement btnSave() {return $(".btn");}
    public SelenideElement menuCloseTask() {return $(".sidebar > ul:nth-child(4) > li:nth-child(14) > a:nth-child(1)");}
    public SelenideElement confirmCloseTask() {return $("#modal-confirm-button");}
    public SelenideElement menuRemoveTask(){return $(".sidebar > ul:nth-child(4) > li:nth-child(14) > a:nth-child(1)");}
    public SelenideElement dropdownMenuFilter() {return $("div.input-addon-item:nth-child(2) > div:nth-child(1) > a");}
    public SelenideElement menuClosedTasks() {return $(".dropdown-submenu-open > li:nth-child(7) > a:nth-child(1)");}



}
