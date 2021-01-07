package registration;

public class RegistrationModule {

    public RegistrationFacade createFacade() {
        return new RegistrationFacade(new InMemoryRegistrationRepository());
    }

}
