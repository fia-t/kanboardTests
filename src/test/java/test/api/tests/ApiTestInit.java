package test.api.tests;

import com.google.common.collect.ImmutableMap;
import org.testng.annotations.BeforeSuite;
import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;
import static utils.EnvProperties.API_URL;

public class ApiTestInit {
    @BeforeSuite
    void setAllureEnvironment(){
        allureEnvironmentWriter(
        ImmutableMap.<String, String>builder()
                .put("URL",API_URL)
                .build(), System.getProperty("user.dir")
                +"target/allure-results");
    }


}
