import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import registration.RegistrationFacade;
import registration.RegistrationRepository;

@Configuration
public class AppConfig {

    @Bean
    RegistrationFacade registrationFacade(final RegistrationRepository registrationRepository) {
        return new RegistrationFacade(registrationRepository);
    }

}
