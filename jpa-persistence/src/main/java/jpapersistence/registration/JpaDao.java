package jpapersistence.registration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaDao extends JpaRepository<RegistrationJpaEntity, String> {

    boolean existsByUsername(final String username);

}
