package jpapersistence.registration;

import domain.common.AggregateId;
import domain.common.Username;
import domain.registration.Password;
import domain.registration.Registration;
import domain.registration.Token;
import domain.registration.api.RegistrationSimpleData;
import jpapersistence.exceptions.CannotLoadFieldException;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class RegistrationJpaEntity {

    @Id
    private String id;
    private String username;
    private String password;
    private boolean confirmed;
    private String token;

    public static RegistrationJpaEntity fromSimpleData(final RegistrationSimpleData simpleData) {
        return RegistrationJpaEntity.builder()
                .id(simpleData.getId())
                .username(simpleData.getUsername())
                .confirmed(simpleData.isConfirmed())
                .token(simpleData.getToken())
                .password(simpleData.getPassword())
                .build();
    }

    public Registration toDomainObject() {
        return Registration.builder()
                .id(new AggregateId(id))
                .confirmed(this.confirmed)
                .username(Username.of(username).getOrElseThrow(() -> new CannotLoadFieldException("username")))
                .password(Password.of(password).getOrElseThrow(() -> new CannotLoadFieldException("password")))
                .token(Token.of(token).getOrElseThrow(() -> new CannotLoadFieldException("token")))
                .build();
    }
}
