package jpa.registration;

import common.AggregateId;
import common.Username;
import lombok.*;
import jpa.registration.api.RegistrationSimpleData;

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
                .username(new Username(username))
                .password(new Password(password))
                .token(new Token(token))
                .build();
    }
}
