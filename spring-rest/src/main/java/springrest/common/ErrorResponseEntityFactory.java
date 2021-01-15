package springrest.common;

import domain.errorapi.DomainError;
import io.vavr.collection.HashMap;
import io.vavr.collection.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import springrestapi.error.RestErrorResponse;

@Component
public class ErrorResponseEntityFactory {

    private final Map<DomainError, HttpStatus> map = HashMap.of(
            DomainError.REGISTRATION_NOT_EXISTS, HttpStatus.NOT_FOUND
    );

    public ResponseEntity<?> create(final DomainError domainError) {
        return ResponseEntity
                .status(map.getOrElse(domainError, HttpStatus.BAD_REQUEST))
                .body(new RestErrorResponse(domainError.name()));
    }
}
