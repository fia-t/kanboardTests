package test.api.requests.project;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class createProjectRequest {
    private String name;
    private String description;
    private Integer owner_id;
    private String identifier;
    private String start_date;
    private String end_date;
}
