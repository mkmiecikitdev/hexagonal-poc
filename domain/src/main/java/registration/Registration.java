package registration;

import common.AggregateId;
import common.Username;
import io.vavr.control.Option;
import registration.api.RegistrationResult;

public class Registration {

    private final AggregateId id;
    private final Username username;
    private final Password password;
    private final Token token;
    private final boolean confirmed;

    public Registration(final String username, final String password) {
        this.id = new AggregateId();
        this.username = new Username(username);
        this.password = new Password(password);
        this.token = new Token();
        this.confirmed = false;
    }

    public Registration(AggregateId id, Username username, Password password, Token token, boolean confirmed) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.token = token;
        this.confirmed = confirmed;
    }

    public Registration confirm(final String token) {
        if (this.token.equals(new Token(token))) {
            return new Registration(
                    this.id,
                    this.username,
                    this.password,
                    null,
                    true
            );
        }

        return new Registration(
                this.id,
                this.username,
                this.password,
                this.token,
                false
        );
    }

    public Registration resetToken() {
        return new Registration(
                this.id,
                this.username,
                this.password,
                new Token(),
                false
        );
    }

    public RegistrationResult toResult() {
        return new RegistrationResult(
                id.getId(),
                username.getUsername(),
                Option.of(token)
                        .map(Token::getToken)
                        .getOrNull(),
                this.confirmed);
    }

    public AggregateId getId() {
        return id;
    }
}
