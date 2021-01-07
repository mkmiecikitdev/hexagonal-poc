package registration.api;

public class RegistrationResult {
    private final String id;
    private final String username;
    private final String token;
    private final boolean confirmed;

    public RegistrationResult(String id, String username, String token, boolean confirmed) {
        this.id = id;
        this.username = username;
        this.token = token;
        this.confirmed = confirmed;
    }

    public String getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getToken() {
        return token;
    }

    public boolean isConfirmed() {
        return confirmed;
    }
}
