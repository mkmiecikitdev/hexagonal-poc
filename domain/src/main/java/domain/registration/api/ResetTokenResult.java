package domain.registration.api;

public class ResetTokenResult {

    private final String id;
    private final String token;

    public ResetTokenResult(String id, String token) {
        this.id = id;
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public String getToken() {
        return token;
    }
}
