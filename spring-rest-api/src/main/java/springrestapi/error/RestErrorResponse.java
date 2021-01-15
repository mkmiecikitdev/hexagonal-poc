package springrestapi.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class RestErrorResponse {

    private final String code;

}
