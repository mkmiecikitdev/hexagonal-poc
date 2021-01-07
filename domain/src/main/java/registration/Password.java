package registration;

import java.util.Objects;

public class Password {

    private final String password;

    public Password(final String password) {
        Objects.requireNonNull(password, "Password cannot be null");
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public boolean equals(final Password password) {
        return this.password.equals(password.password);
    }
}
