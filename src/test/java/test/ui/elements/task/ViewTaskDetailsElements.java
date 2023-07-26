package test.ui.elements.task;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ViewTaskDetailsElements {
    public SelenideElement taskDetailCreator(){return $("div.task-summary-column:nth-child(3) > ul:nth-child(1) > li:nth-child(2) > span:nth-child(2)");}
    public static SelenideElement taskDetailTitle(){return $("#task-summary > h2:nth-child(1)");}
    public static SelenideElement taskBoardTitle(){return $(".task-board-title > a:nth-child(1)");}
    public static SelenideElement taskListTitle(){return $(".table-list-title  > a:nth-child(1)");}
    public SelenideElement statusOpenTask(){return $("div.task-summary-column:nth-child(1) > ul:nth-child(1) > li:nth-child(1) > span:nth-child(2)");}
    public SelenideElement statusClosedTask(){return $(".table-list .task-board-closed");}

    public static SelenideElement addComment(){return $(".sidebar > ul:nth-child(4) > li:nth-child(6) > a:nth-child(1)");}
    public static SelenideElement fieldComment(){return $("#modal-content textarea:nth-child(2)");}
    public static SelenideElement btnSaveComment(){return $("#modal-content button:nth-child(1)");}
    public static SelenideElement commentUsername(){return $(".comment-username");}
    public static SelenideElement comment(){return $("div.markdown:nth-child(1) > p:nth-child(1)");}
    public static SelenideElement commentAction(){return $(".comment-actions a.dropdown-menu");}
    public static SelenideElement commentRemove(){return $(".dropdown-submenu-open > li:nth-child(3) > a:nth-child(1)");}
    public static SelenideElement btnYes(){return $("#modal-confirm-button");}





}
