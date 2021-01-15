package springrest.registration;

import domain.registration.RegistrationFacade;
import domain.registration.api.RegistrationResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegistrationRestController {

    private final RegistrationFacade registrationFacade;

    @GetMapping("/add")
    RegistrationResult test() {
        return registrationFacade.register("bobo", "pass");
    }

    @GetMapping("/confirm")
    RegistrationResult confirm() {
        return registrationFacade.confirm("bobo", "pass");
    }
}
