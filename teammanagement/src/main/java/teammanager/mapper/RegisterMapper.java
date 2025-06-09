package teammanager.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import teammanager.dto.user.RegisterRequest;
import teammanager.entity.User;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface RegisterMapper {
    User toEntity(RegisterRequest registerRequest);
}
