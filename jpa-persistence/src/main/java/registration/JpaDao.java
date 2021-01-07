package registration;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaDao extends JpaRepository<RegistrationJpaEntity, String> {

    boolean existByUsername(final String username);

}
