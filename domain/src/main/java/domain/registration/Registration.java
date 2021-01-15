package domain.registration;

import domain.common.AggregateId;
import domain.common.Username;
import domain.registration.api.RegistrationSimpleData;
import io.vavr.control.Option;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
public class Registration {

    private final AggregateId id;
    private final Username username;
    private final Password password;
    private final Token token;
    private final boolean confirmed;

    public Registration(final Username username, final Password password) {
        this.id = new AggregateId();
        this.username = username;
        this.password = password;
        this.token = Token.random();
        this.confirmed = false;
    }

    public Registration confirm(final Token token) {
        if (this.token.equals(token)) {
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
                Token.random(),
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
