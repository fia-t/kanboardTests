package test.api.requests.projectuser;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class removeProjectUserRequest {
    private Integer project_id;
    private Integer user_id;
}
