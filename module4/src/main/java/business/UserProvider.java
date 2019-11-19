package business;

import java.util.Properties;

public final class UserProvider {

    private static final String PROPERTY_FILE_LOCATION = "src/main/resources/users.properties";
    private static Properties property;

    static {
        property = PropertyReader.readProperty(PROPERTY_FILE_LOCATION);
    }

    private UserProvider() {
    }

    public static User getUser(String id) {
        return User.builder()
                .withLogin(property.getProperty(String.format("user_%s_login", id)))
                .withPass(property.getProperty(String.format("user_%s_password", id)))
                .build();
    }
}
