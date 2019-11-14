package business;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class UserProvider {

    private static final String PROPERTY_FILE_LOCATION = "src/main/resources/users.properties";
    private static Properties property;

    static {
        try (FileInputStream fis = new FileInputStream(PROPERTY_FILE_LOCATION)) {
            property = new Properties();
            property.load(fis);

        } catch (IOException e) {
            System.err.println("Couldn't not init properties.");
        }
    }

    private UserProvider() {
    }

    public static User getUser(String id) {
        return new User(
                (property.getProperty(String.format("user_%s_login", id))),
                (property.getProperty(String.format("user_%s_password", id)))
        );
    }
}
