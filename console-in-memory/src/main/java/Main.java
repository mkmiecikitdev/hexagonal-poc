import presentation.ConsoleApp;
import presentation.ConsoleAppModule;
import jpa.registration.RegistrationModule;

public class Main {
    public static void main(String[] args) {
        final ConsoleAppModule consoleAppModule = new ConsoleAppModule(
                new RegistrationModule().createFacade()
        );

        new ConsoleApp(consoleAppModule).start();
    }
}

