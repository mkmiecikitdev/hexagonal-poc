package registration;

import common.AggregateId;
import common.Username;
import io.vavr.control.Option;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import registration.api.RegistrationSimpleData;

@Builder
@RequiredArgsConstructor
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

    public RegistrationSimpleData toSimpleData() {
        return RegistrationSimpleData.builder()
                .id(id.getId())
                .username(username.getUsername())
                .password(password.getPassword())
                .confirmed(this.confirmed)
                .token(Option.of(token)
                        .map(Token::getToken)
                        .getOrNull())
                .build();
    }

    public AggregateId getId() {
        return id;
    }
}
