package lesson4;

public class User {
    @JsonField(name = "id")
    private int userId;

    @JsonField(name = "name")
    private String username;

    @JsonField(name = "email")
    private String userEmail;

    public User(int userId, String username, String userEmail) {
        this.userId = userId;
        this.username = username;
        this.userEmail = userEmail;
    }
}