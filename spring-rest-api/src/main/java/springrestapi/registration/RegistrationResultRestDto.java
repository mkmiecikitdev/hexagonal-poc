package springrestapi.registration;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class RegistrationResultRestDto {
    private String id;
    private String username;
    private String token;
    private boolean confirmed;
}
