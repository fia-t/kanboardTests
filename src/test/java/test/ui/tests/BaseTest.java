package test.ui.tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static test.configuration.browserConfiguration.setBrowserConfiguration;
import static utils.EnvProperties.BASE_URL;

public class BaseTest {
    @BeforeClass
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {
        Configuration.baseUrl = BASE_URL;
        setBrowserConfiguration(browser);
    }

    @AfterMethod(alwaysRun = true)
    public void cleanUp() {
        closeWebDriver();
    }

    @DataProvider(name = "browsers")
    public static Object[][] browsersData() {
        return new Object[][]{
                {"chrome"},
                {"headless"},
                {"firefox"},
        };
    }
}
