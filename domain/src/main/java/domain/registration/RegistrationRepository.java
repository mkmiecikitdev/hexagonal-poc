package domain.registration;

import domain.common.AggregateId;
import domain.common.Username;
import io.vavr.control.Option;

public interface RegistrationRepository {

    Registration save(final Registration registration);

    Option<Registration> findById(final AggregateId aggregateId);

    boolean existByName(final Username username);

}
