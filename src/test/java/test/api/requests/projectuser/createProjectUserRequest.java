package test.api.requests.projectuser;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class createProjectUserRequest {
    private Integer project_id;
    private Integer user_id;
//    private String role;
}
