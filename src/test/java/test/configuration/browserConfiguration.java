package test.configuration;

import com.codeborne.selenide.Configuration;

public class browserConfiguration {
    public static void browserConfiguration(String browser) {
        if (browser.equals("headless")) {
            Configuration.headless = true;
            Configuration.browser = "chrome";
        } else {
            Configuration.headless = false;
            Configuration.browser = browser;
        }
    }
}
