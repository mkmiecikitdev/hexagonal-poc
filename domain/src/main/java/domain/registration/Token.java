package domain.registration;

import java.util.UUID;

import static java.util.Objects.requireNonNull;

public class Token {

    private final String token;

    public Token() {
        this.token = UUID.randomUUID().toString();
    }

    public Token(String token) {
        this.token = requireNonNull(token, "Token cannot be null");
    }

    public String getToken() {
        return token;
    }

    public boolean equals(final Token other) {
        return this.token.equals(other.token);
    }
}
