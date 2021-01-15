package consoleinmemory.config;

import domain.registration.RegistrationFacade;

public class ConsoleAppModule {

    private final RegistrationFacade registrationFacade;

    public ConsoleAppModule() {
        this.registrationFacade = new RegistrationModule().createFacade();
    }

    public RegistrationFacade getRegistrationFacade() {
        return registrationFacade;
    }
}
