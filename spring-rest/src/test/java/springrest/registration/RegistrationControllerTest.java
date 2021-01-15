package springrest.registration;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import springrest.Main;
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

        final RegistrationResultRestDto register = client.register();

        Assertions.assertThat(register).isNotNull();
    }
}
