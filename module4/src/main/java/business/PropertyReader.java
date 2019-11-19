package business;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

class PropertyReader {

    static Properties readProperty(String path) {
        try (FileInputStream fis = new FileInputStream(path)) {
            Properties properties = new Properties();
            properties.load(fis);
            return properties;

        } catch (IOException e) {
            System.err.println("Couldn't not init properties.");
            return null;
        }
    }
}
