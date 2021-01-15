package domain.registration;

import domain.common.AggregateId;
import domain.common.Username;
import domain.errorapi.DomainError;
import domain.errorapi.DomainResponseList2;
import domain.registration.api.RegistrationResult;
import domain.registration.api.ResetTokenResult;
import io.vavr.control.Either;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RegistrationFacade {

    private final RegistrationRepository registrationRepository;

    public Either<DomainError, RegistrationResult> register(final String username, final String password) {
        return new DomainResponseList2<>(Username.of(username), Password.of(password))
                .flatMapOrFirstError(successes -> createIfPossible(successes.success1, successes.success2));
    }

    private Either<DomainError, RegistrationResult> createIfPossible(final Username username, final Password password) {
        if (registrationRepository.existByName(username)) {
            return DomainError.USERNAME_EXISTS.toEither();
        }

        final Registration saved = registrationRepository.save(new Registration(username, password));
        return Either.right(RegistrationResult.of(saved.toSimpleData()));
    }

    public Either<DomainError, RegistrationResult> confirm(final String id, final String token) {
        return Token.of(token)
                .flatMap(validatedToken -> registrationRepository.findById(new AggregateId(id))
                        .toEither(DomainError.REGISTRATION_NOT_EXISTS)
                        .map(it -> it.confirm(validatedToken))
                        .map(registrationRepository::save)
                        .map(Registration::toSimpleData)
                        .map(RegistrationResult::of)
                );
    }

    public Either<DomainError, ResetTokenResult> resetToken(final String id) {
        return registrationRepository.findById(new AggregateId(id))
                .toEither(DomainError.REGISTRATION_NOT_EXISTS)
                .map(Registration::resetToken)
                .map(registrationRepository::save)
                .map(it -> new ResetTokenResult(id, it.toSimpleData().getToken()));
    }
}
