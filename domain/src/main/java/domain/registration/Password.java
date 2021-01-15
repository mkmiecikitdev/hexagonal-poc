package domain.registration;

import domain.errorapi.DomainError;
import io.vavr.control.Either;
import io.vavr.control.Option;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Password {

    private final String password;

    public static Either<DomainError, Password> of(final String password) {
        return Option.of(password)
                .toEither(DomainError.PASSWORD_NULL)
                .map(Password::new);
    }

    public String getPassword() {
        return password;
    }

    public boolean equals(final Password password) {
        return this.password.equals(password.password);
    }
}
