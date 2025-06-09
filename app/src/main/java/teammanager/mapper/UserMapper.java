package teammanager.mapper;

import org.mapstruct.*;
import teammanager.dto.user.UserRequest;
import teammanager.dto.user.UserResponse;
import teammanager.entity.User;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserResponse toDTO(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(UserRequest userRequest, @MappingTarget User user);
}
