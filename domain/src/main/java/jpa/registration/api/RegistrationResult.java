package jpa.registration.api;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class RegistrationResult {
    private final String id;
    private final String username;
    private final String token;
    private final boolean confirmed;

    public static RegistrationResult of(final RegistrationSimpleData data) {
        return RegistrationResult.builder()
                .id(data.getId())
                .confirmed(data.isConfirmed())
                .token(data.getToken())
                .username(data.getUsername())
                .build();
    }
}
