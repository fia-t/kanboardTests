package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static java.util.Objects.isNull;

public class EnvProperties {
    private static final String PATH_TO_RESOURCE = "src/test/resources/";
    private static final String PROPERTIES_FILE_EXTENSION = ".properties";
    private static final String DEFAULT_ENVIRONMENT = "local";
    private static final String ENVIRONMENT = System.getProperty("environment", DEFAULT_ENVIRONMENT);

    public static final String API_URL = propertyValue("apiUrl");
    public static final String BASE_URL = propertyValue("baseUrl");
    public static final String API_USERNAME = propertyValue("username");
    public static final String API_TOKEN = propertyValue("token");

    private static String propertyValue(String propertyName) {
        String systemProperty = System.getProperty(propertyName);
        return !isNull(systemProperty) ? systemProperty : getPropertyValue(propertyName);
    }

    private static String getPropertyValue(String propertyName) {
        String environmentFileName = "env." + ENVIRONMENT + PROPERTIES_FILE_EXTENSION;
        Properties prop = new Properties();
        try (FileInputStream fis = new FileInputStream(PATH_TO_RESOURCE + environmentFileName)) {
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Cannot load environment properties file: " + environmentFileName, e);
        }
        return prop.getProperty(propertyName);
    }
}

