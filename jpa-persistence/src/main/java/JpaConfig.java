import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import registration.JpaDao;
import registration.JpaRegistrationRepository;
import registration.RegistrationRepository;

@Configuration
public class JpaConfig {

    @Bean
    RegistrationRepository registrationRepository(final JpaDao jpaDao) {
        return new JpaRegistrationRepository(jpaDao);
    }

}
