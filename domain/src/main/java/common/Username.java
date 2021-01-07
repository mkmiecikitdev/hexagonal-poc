package common;

import static java.util.Objects.requireNonNull;

public class Username {

    private final String username;

    public Username(String username) {
        requireNonNull(username, "Name cannot be null");
        final String trimAndLowerCase = username.trim().toLowerCase();
        this.username = trimAndLowerCase.substring(0, 1).toUpperCase() + trimAndLowerCase.substring(1);
    }

    public String getUsername() {
        return username;
    }

}
