package presentation;

import lombok.RequiredArgsConstructor;
import registration.RegistrationFacade;
import registration.api.RegistrationResult;

@RequiredArgsConstructor
public class ConsoleApp {

    private final RegistrationFacade registrationFacade;

    public ConsoleApp(ConsoleAppModule consoleAppModule) {
        this.registrationFacade = consoleAppModule.getRegistrationFacade();
    }

    public void start() {
        final RegistrationResult result = registrationFacade.register("USERNAME", "PAZZ");
        final String myId = result.getId();
        final String myToken = result.getToken();

        final RegistrationResult confirmResult = registrationFacade.confirm(myId, myToken);
    }
}
