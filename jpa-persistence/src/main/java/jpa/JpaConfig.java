package jpa;

import jpa.registration.JpaDao;
import jpa.registration.JpaRegistrationRepository;
import jpa.registration.RegistrationRepository;
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
