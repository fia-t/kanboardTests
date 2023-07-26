package test.api.requests.task;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class createTaskRequest {
    private String title;
    private String description;
    private Integer owner_id;
    private Integer creator_id;
    private Integer project_id;
    private String color_id;
    private Integer column_id;
}
