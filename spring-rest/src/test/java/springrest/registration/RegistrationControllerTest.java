package springrest.registration;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import springrest.Main;
import springrestapi.registration.RegistrationResultRestDto;
import springrestclient.registration.RegistrationClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Main.class)
public class RegistrationControllerTest {

    @LocalServerPort
    private int port;

    @Test
    public void should() {
        final RegistrationClient client = new RegistrationClient("localhost", port);

        final RegistrationResultRestDto register = client.register();

        System.out.printf("dupa");
    }

}
