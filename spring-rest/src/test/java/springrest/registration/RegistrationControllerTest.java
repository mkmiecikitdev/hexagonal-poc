package springrest.registration;

import io.vavr.control.Either;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import springrest.Main;
import springrestapi.error.RestErrorResponse;
import springrestapi.registration.RegistrationResultRestDto;
import springrestclient.registration.RegistrationClient;
import springrestclient.registration.RegistrationClientFactory;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Main.class)
public class RegistrationControllerTest {

    @LocalServerPort
    private int port;

    @Test
    public void shouldReturnNotNull() {
        final RegistrationClient client = RegistrationClientFactory.create("localhost", port);

        final Either<RestErrorResponse, RegistrationResultRestDto> result = client.register();

        Assertions.assertThat(result).isNotNull();
    }
}
