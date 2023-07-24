package test.ui.steps.task;

import com.codeborne.selenide.Configuration;
//import test.ui.elements.task.TaskElements;
import io.qameta.allure.Step;
import test.ui.elements.task.*;
import test.ui.steps.project.ProjectPage;

import static com.codeborne.selenide.Condition.visible;
//import static test.ui.elements.task.ViewTaskDetailsElements.addComment;

public class TaskPage extends TaskElements {
    @Step("go to Board")
    public TaskPage goToBoard() {
        Configuration.timeout = 5000;
        ProjectPage.viewBoard().shouldBe(visible).click();
        return this;
    }
    @Step("go to List")
    public TaskPage goToList() {
        Configuration.timeout = 5000;
        ProjectPage.viewList().shouldBe(visible).click();
        return this;
    }

    @Step("go to Task from Board")
    public ViewBoardPage goToTaskFromBoard() {
        Configuration.timeout = 10000;
        ViewTaskDetailsElements.taskBoardTitle().shouldBe(visible).click();
        ViewTaskDetailsElements.taskDetailTitle().shouldBe(visible);

        return new ViewBoardPage();
    }
    @Step("go to Task from List")
    public ViewBoardPage goToTaskFromList() {
        Configuration.timeout = 10000;
        ViewTaskDetailsElements.taskListTitle().shouldBe(visible).click();
        ViewTaskDetailsElements.taskDetailTitle().shouldBe(visible);

        return new ViewBoardPage();
    }
    @Step("create Task")
    public ViewBoardPage createTask(String taskTitle) {
        Configuration.timeout = 10000;
        ProjectPage.goToProject();
        goToBoard();
        addTaskBacklog().shouldBe(visible).click();
        titleTask().shouldBe(visible).sendKeys(taskTitle);
        btnSave().click();
        return new ViewBoardPage();
    }

    @Step("close Task")
    public ViewBoardPage closeTask() {
        Configuration.timeout = 20000;
        ProjectPage.goToProject();
        goToList();
        goToTaskFromList();
        menuCloseTask().shouldBe(visible).click();
        confirmCloseTask().shouldBe(visible).click();
        return new ViewBoardPage();
    }
    @Step("filter closed Task")
    public ViewBoardPage filterClosedTasks() {
        Configuration.timeout = 20000;
        dropdownMenuFilter().shouldBe(visible).click();
        menuClosedTasks().shouldBe(visible).click();
        return new ViewBoardPage();
    }
    public ViewBoardPage removeTask() {
        Configuration.timeout = 10000;
        ProjectPage.goToProject();
        goToList();
        goToTaskFromList();
        menuRemoveTask().shouldBe(visible).click();
        confirmCloseTask().shouldBe(visible).click();
        return new ViewBoardPage();
    }
    @Step("add Comment For Task")
    public ViewBoardPage addCommentForTasks(String comment) {
        Configuration.timeout = 10000;
        ProjectPage.goToProject();
        goToList();
        goToTaskFromList();
        ViewTaskDetailsElements.addComment().shouldBe(visible).click();
        ViewTaskDetailsElements.fieldComment().shouldBe(visible).sendKeys(comment);
        ViewTaskDetailsElements.btnSaveComment().shouldBe(visible).click();
        return new ViewBoardPage();
    }
    public ViewBoardPage removeCommentForTasks(String comment) {
        Configuration.timeout = 10000;
        ProjectPage.goToProject();
        goToList();
        goToTaskFromList();
        ViewTaskDetailsElements.commentAction().shouldBe(visible).click();
        ViewTaskDetailsElements.commentRemove().shouldBe(visible).click();
        ViewTaskDetailsElements.btnYes().shouldBe(visible);
        return new ViewBoardPage();
    }
}
