package springrestclient.registration;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.vavr.control.Either;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import springrestapi.error.RestErrorResponse;
import springrestapi.registration.RegistrationResultRestDto;

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
    public Either<RestErrorResponse, RegistrationResultRestDto> register() {
        return Try.of(() -> {
            final HttpRequest request = HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(baseUrl + "/add"))
                    .build();

            return client.send(request, HttpResponse.BodyHandlers.ofString());
        })
                .toEither(new RestErrorResponse("UNKNOWN_REST_ERROR"))
                .flatMap(this::tryParseResponse);
    }

    private Either<RestErrorResponse, RegistrationResultRestDto> tryParseResponse(final HttpResponse<String> response) {
        if (response.statusCode() == 200 || response.statusCode() == 201) {
            return Try.of(() -> objectMapper.readValue(response.body(), RegistrationResultRestDto.class))
                    .toEither(new RestErrorResponse("CANNOT_PARSE_SUCCESS_RESPONSE"));
        }

        return Try.of(() -> objectMapper.readValue(response.body(), RestErrorResponse.class))
                .fold(
                        error -> Either.left(new RestErrorResponse("CANNOT_PARSE_ERROR_RESPONSE")),
                        Either::left
                );
    }
}
