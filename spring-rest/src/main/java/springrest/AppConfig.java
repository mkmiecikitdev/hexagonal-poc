package springrest;

import jpa.JpaConfig;
import jpa.registration.RegistrationFacade;
import jpa.registration.RegistrationRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(JpaConfig.class)
public class AppConfig {
    @Bean
    RegistrationFacade registrationFacade(final RegistrationRepository registrationRepository) {
        return new RegistrationFacade(registrationRepository);
    }
}
