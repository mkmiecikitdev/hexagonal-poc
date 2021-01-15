package consoleinmemory.presentation;

import consoleinmemory.config.ConsoleAppModule;
import domain.registration.RegistrationFacade;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ConsoleApp {

    private final RegistrationFacade registrationFacade;

    public ConsoleApp(ConsoleAppModule consoleAppModule) {
        this.registrationFacade = consoleAppModule.getRegistrationFacade();
    }

    public void start() {
        registrationFacade.register("USERNAME", "PAZZ")
                .map(result -> {
                    final String myId = result.getId();
                    final String myToken = result.getToken();

                    registrationFacade.confirm(myId, myToken)
                            .map(it -> {
                                System.out.println(it);
                                return 1;
                            });

                    return 0;
                });
    }
}
