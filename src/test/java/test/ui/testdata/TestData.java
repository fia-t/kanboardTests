package test.ui.testdata;
public class TestData {
    static String environment = System.getProperty("environment", "local");
    public final static String adminUSERNAME;
    public final static String adminPASSWORD;

    public final static String username = "admin123";
    public final static String password = "admin123";
    public final static String USERNAME = "admin2";
    public final static String PASSWORD = "admin2Password";
    public final static String usernameInCorrect = "test";
    public final static String passwordInCorrect = "test";
    public final static String errorMessage = "Bad username or password";
    public final static String dashboardAfterSigninMessage = "Dashboard for ";
    public final static String projectNAME = "My project";
    public final static String noProjectTitle = "Projects (0)";
    public final static String noProjectMessage = "There is no project.";
    public final static String taskTitle = "test Task";
    public final static String taskStatusClose = "Closed";
    public final static String taskStatusOpen = "open";
    public final static String taskDescription = "test task description";
    public final static String taskColor = "green";
//    public final static Integer taskColumnId = 289;
    public final static String comment = "test comment";

    static {
        if (environment.equals("local")) {
            adminUSERNAME = "admin";
            adminPASSWORD = "admin";
            ////    public final static String USERNAME = "user2007";
            ////    public final static String PASSWORD = "myTestPassword";
        } else {
            adminUSERNAME = "fia";
            adminPASSWORD = "FiaAdmin!!!";
        }
    }
}
