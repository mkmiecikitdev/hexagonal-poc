package common;

import io.vavr.control.Either;

/** It will be used in next versions */

public enum DomainError {

    USERNAME_NULL,
    PASSWORD_NULL,
    TOKEN_NULL,

    USERNAME_EXIST;

    public <T> Either<DomainError, T> toEither(final DomainError domainError) {
        return Either.left(domainError);
    }
}
