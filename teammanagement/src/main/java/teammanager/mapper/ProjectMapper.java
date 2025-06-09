package teammanager.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import teammanager.dto.project.ProjectRequest;
import teammanager.entity.Project;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ProjectMapper {
     Project toEntity(ProjectRequest projectRequest);
     ProjectRequest toDTO(Project project);
}
