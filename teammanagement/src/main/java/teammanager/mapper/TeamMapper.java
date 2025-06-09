package teammanager.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import teammanager.dto.team.CreateTeamRequest;
import teammanager.entity.Team;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface TeamMapper {
    @Mapping(target = "leader", ignore = true)
    Team toEntity(CreateTeamRequest createTeamRequest);
}
