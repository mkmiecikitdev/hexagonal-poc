package consoleinmemory.config;

import inmemorypersistence.InMemoryRegistrationRepository;
import domain.registration.RegistrationFacade;

public class RegistrationModule {

    public RegistrationFacade createFacade() {
        return new RegistrationFacade(new InMemoryRegistrationRepository());
    }

}
