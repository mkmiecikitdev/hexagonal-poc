package domain.registration.api;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class RegistrationSimpleData {
    private final String id;
    private final String username;
    private final String password;
    private final String token;
    private final boolean confirmed;
}
