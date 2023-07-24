package test.ui.tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static utils.EnvProperties.BASE_URL;

public class BaseTest {

    @BeforeMethod
    public void setUp() {
        Configuration.baseUrl = BASE_URL;
    }

    @AfterMethod(alwaysRun = true)
    public void cleanUp() {
        closeWebDriver();
    }
    @DataProvider(name = "browsers")
    public static Object[][] browsersData() {
        return new Object[][]{
                {"chrome"},
//                {"headless"},
//                {"firefox"},
        };
    }

}
