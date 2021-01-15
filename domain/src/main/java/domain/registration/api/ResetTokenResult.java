package domain.registration.api;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ResetTokenResult {

    private final String id;

    private final String token;

}
