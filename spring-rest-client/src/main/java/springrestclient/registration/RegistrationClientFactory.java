package springrestclient.registration;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RegistrationClientFactory {

    public static RegistrationClient create(final String host, final int port) {
        return new HttpRegistrationClient(host, port);
    }
}
