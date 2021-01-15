package jpapersistence;

import domain.registration.RegistrationRepository;
import jpapersistence.registration.JpaDao;
import jpapersistence.registration.JpaRegistrationRepository;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
public class JpaConfig {

    @Bean
    RegistrationRepository registrationRepository(final JpaDao jpaDao) {
        return new JpaRegistrationRepository(jpaDao);
    }

}
