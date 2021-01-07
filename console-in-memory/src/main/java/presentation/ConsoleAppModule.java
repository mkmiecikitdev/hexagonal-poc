package presentation;

import registration.RegistrationFacade;

public class ConsoleAppModule {

    private final RegistrationFacade registrationFacade;

    public ConsoleAppModule(RegistrationFacade registrationFacade) {
        this.registrationFacade = registrationFacade;
    }

    public RegistrationFacade getRegistrationFacade() {
        return registrationFacade;
    }
}
