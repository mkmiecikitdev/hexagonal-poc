package domain.errorapi;

import io.vavr.control.Either;

public enum DomainError {

    USERNAME_NULL,
    PASSWORD_NULL,
    TOKEN_NULL,

    REGISTRATION_NOT_EXISTS,

    USERNAME_EXISTS;

    public <T> Either<DomainError, T> toEither() {
        return Either.left(this);
    }
}
