package springrestapi.registration;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class RegistrationResultRestDto {
    private final String id;
    private final String username;
    private final String token;
    private final boolean confirmed;
}
