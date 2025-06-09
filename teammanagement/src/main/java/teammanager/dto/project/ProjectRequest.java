package teammanager.dto.project;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProjectRequest {
    @NotBlank(message = "{projectName.notBlank}")
    @Pattern(regexp = "^[A-Za-z\\d]{4,20}$", message = "{projectName.invalid}")
    private String name;

    private String description;

    @Pattern(regexp = "^[1-9]\\d*$", message = "{teamId.invalid}")
    private Long teamId;
}
