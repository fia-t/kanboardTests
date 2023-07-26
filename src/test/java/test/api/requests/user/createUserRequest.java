package test.api.requests.user;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class createUserRequest {
    private String username;
    private String password;
    private String name;
    private String email;
    private String role;
}
