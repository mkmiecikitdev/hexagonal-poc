package springrestclient.registration;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import springrestapi.registration.RegistrationResultRestDto;
import springrestclient.common.RestClientException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@RequiredArgsConstructor
class HttpRegistrationClient implements RegistrationClient {

    private final HttpClient client = HttpClient.newBuilder().build();
    private final String baseUrl;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public HttpRegistrationClient(String host, int port) {
        this.baseUrl = String.format("http://%s:%d", host, port);
    }

    @Override
    public RegistrationResultRestDto register() {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(baseUrl + "/add"))
                .build();
        try {
            final HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return objectMapper.readValue(response.body(), RegistrationResultRestDto.class);
        } catch (IOException | InterruptedException e) {
            throw new RestClientException();
        }
    }
}
