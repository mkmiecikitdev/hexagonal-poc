package domain.registration;

import domain.common.AggregateId;
import domain.common.Username;
import domain.registration.api.RegistrationNotExist;
import domain.registration.api.RegistrationResult;
import domain.registration.api.ResetTokenResult;
import domain.registration.api.UsernameExistException;

public class RegistrationFacade {

    private final RegistrationRepository registrationRepository;

    public RegistrationFacade(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public RegistrationResult register(final String username, final String password) {
        if (registrationRepository.existByName(new Username(username))) {
            throw new UsernameExistException();
        }

        final Registration saved = registrationRepository.save(new Registration(username, password));
        return RegistrationResult.of(saved.toSimpleData());
    }

    public RegistrationResult confirm(final String id, final String token) {
        return registrationRepository.findById(new AggregateId(id))
                .map(it -> it.confirm(token))
                .map(registrationRepository::save)
                .map(Registration::toSimpleData)
                .map(RegistrationResult::of)
                .getOrElseThrow(RegistrationNotExist::new);
    }

    public ResetTokenResult resetToken(final String id) {
        return registrationRepository.findById(new AggregateId(id))
                .map(Registration::resetToken)
                .map(registrationRepository::save)
                .map(it -> new ResetTokenResult(id, it.toSimpleData().getToken()))
                .getOrElseThrow(RegistrationNotExist::new);
    }
}
