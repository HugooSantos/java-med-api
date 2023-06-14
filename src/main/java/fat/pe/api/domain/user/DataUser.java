package fat.pe.api.domain.user;

import jakarta.validation.constraints.NotBlank;

public record DataUser(
        @NotBlank
        String login,
        @NotBlank
        String password) {
    public DataUser(User user){
        this(user.getLogin(),  user.getPassword());
    }
}
