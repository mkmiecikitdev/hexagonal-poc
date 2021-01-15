package springrest.config;

import domain.registration.RegistrationFacade;
import domain.registration.RegistrationRepository;
import jpapersistence.JpaConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(JpaConfig.class)
public class RestServerConfig {
    @Bean
    RegistrationFacade registrationFacade(final RegistrationRepository registrationRepository) {
        return new RegistrationFacade(registrationRepository);
    }
}
