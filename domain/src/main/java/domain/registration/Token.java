package domain.registration;

import domain.errorapi.DomainError;
import io.vavr.control.Either;
import io.vavr.control.Option;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class Token {

    private final String token;

    public static Token random() {
        return new Token(UUID.randomUUID().toString());
    }

    public static Either<DomainError, Token> of(final String token) {
        return Option.of(token)
                .toEither(DomainError.TOKEN_NULL)
                .map(Token::new);
    }

    public String getToken() {
        return token;
    }

    public boolean equals(final Token other) {
        return this.token.equals(other.token);
    }
}
