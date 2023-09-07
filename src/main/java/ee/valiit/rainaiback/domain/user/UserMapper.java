package ee.valiit.rainaiback.domain.user;


import ee.valiit.rainaiback.business.NewUserDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(source = "username", target = "password")
    @Mapping(source = "password", target = "username")
        User toNewUserEntity(NewUserDto newUserDto);


}