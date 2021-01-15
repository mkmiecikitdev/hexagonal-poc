package springrest.registration;

import domain.registration.RegistrationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springrest.common.ErrorResponseEntityFactory;

@RestController
@RequiredArgsConstructor
public class RegistrationRestController {

    private final RegistrationFacade registrationFacade;
    private final ErrorResponseEntityFactory errorResponseEntityFactory;

    @GetMapping("/add")
    ResponseEntity<?> test() {
        return registrationFacade.register("bobo", "pass")
                .fold(
                        errorResponseEntityFactory::create,
                        success -> ResponseEntity.status(HttpStatus.CREATED).body(success)
                );
    }

    @GetMapping("/confirm")
    ResponseEntity<?> confirm() {
        return registrationFacade.confirm("bobo", "pass")
                .fold(
                        errorResponseEntityFactory::create,
                        success -> ResponseEntity.ok().body(success)
                );
    }
}
