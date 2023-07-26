package test.ui.steps.task;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import test.ui.elements.task.ViewTaskDetailsElements;

import static com.codeborne.selenide.Condition.visible;

public class ViewBoardPage extends ViewTaskDetailsElements {
    @Step("Is task Board Assignee text visible")
    public boolean isTaskDetailCreatorTextVisible() {
        return taskDetailCreator().is(visible);
    }
    @Step("Get task detail creator text")
    public String getTaskDetailCreatorText() {
        return taskDetailCreator().getText();
    }
    @Step("Is task Board Title text visible")
    public boolean isTaskBoardTitleTextVisible() {
        return taskBoardTitle().is(visible);
    }

    @Step("Is detail task Title text visible")
    public boolean isTaskDetailTitleTextVisible() {
        return taskDetailTitle().is(visible);
    }
    @Step("Get task Board Title text")
    public String getTaskBoardTitleText() {
        Configuration.timeout = 10000;
        taskDetailTitle().is(visible);
        return taskBoardTitle().getText();
    }
    @Step("Get task Detail Title text")
    public String getTaskDetailTitleText() {
        return taskDetailTitle().getText();
    }

    @Step("Is task status visible")
    public boolean isTaskStatusOpenTextVisible() {
        return statusOpenTask().is(visible);
    }
    @Step("Get task Status Open")
    public String getTaskStatusOpen() {
        Configuration.timeout = 10000;
        statusOpenTask().is(visible);
        return statusOpenTask().getText();
    }
    @Step("Get task Status Closed")
    public String getTaskStatusClosed() {
        Configuration.timeout = 10000;
        statusClosedTask().is(visible);
        return statusClosedTask().getText();
    }

    @Step("Comment should be added")
    public String getCommentForTask() {
        Configuration.timeout = 10000;
        comment().is(visible);
        return comment().getText();
    }
    @Step("Comment should be added by username")
    public String getCommentForTaskUser() {
        Configuration.timeout = 10000;
        commentUsername().is(visible);
        return commentUsername().getText();
    }


}
