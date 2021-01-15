package springrestclient.registration;

import io.vavr.control.Either;
import springrestapi.error.RestErrorResponse;
import springrestapi.registration.RegistrationResultRestDto;

public interface RegistrationClient {

    Either<RestErrorResponse, RegistrationResultRestDto> register();

}
