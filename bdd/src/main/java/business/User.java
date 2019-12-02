package business;

public class User {

    private String login;
    private String password;

    User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    static UserBuilder builder() {
        return new UserBuilder();
    }

    public static class UserBuilder {
        private String login;
        private String password;

        UserBuilder withLogin(String login) {
            this.login = login;
            return this;
        }

        UserBuilder withPass(String pass) {
            this.password = pass;
            return this;
        }

        User build() {
            return new User(login, password);
        }
    }

}
