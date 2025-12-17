package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

    private static Properties prop;

    static {
        loadConfig();
    }

    private static void loadConfig() {
        try {
            prop = new Properties();
            // config.properties is in src/test/resources (on classpath)
            InputStream is = ConfigReader.class
                    .getClassLoader()
                    .getResourceAsStream("config.properties");

            if (is == null) {
                throw new RuntimeException("config.properties not found on classpath");
            }

            prop.load(is);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String get(String key) {
        return prop.getProperty(key);
    }
}
