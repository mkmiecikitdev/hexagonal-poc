package domain.common;

import domain.errorapi.DomainError;
import io.vavr.control.Either;
import io.vavr.control.Option;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Username {

    private final String username;

    public static Either<DomainError, Username> of(final String username) {
        return Option.of(username)
                .toEither(DomainError.USERNAME_NULL)
                .map(Username::transform)
                .map(Username::new);
    }

    private static String transform(final String beforeTransformation) {
        final String trimAndLowerCase = beforeTransformation.trim().toLowerCase();
        return trimAndLowerCase.substring(0, 1).toUpperCase() + trimAndLowerCase.substring(1);
    }

    public String getUsername() {
        return username;
    }

}
