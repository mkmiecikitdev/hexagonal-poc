package jpa.registration;

import common.AggregateId;
import common.Username;
import io.vavr.control.Option;

public interface RegistrationRepository {

    Registration save(final Registration registration);

    Option<Registration> findById(final AggregateId aggregateId);

    boolean existByName(final Username username);

}
