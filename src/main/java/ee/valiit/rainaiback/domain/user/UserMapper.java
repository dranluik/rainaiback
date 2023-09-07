package ee.valiit.rainaiback.domain.user;

import ee.valiit.rainaiback.business.NewUserDto;
import ee.valiit.rainaiback.business.login.LoginResponse;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(source = "packageType.name", target = "packageTypeName")
    @Mapping(source = "role.name", target = "roleName")
    @Mapping(source = "id", target = "userId")
    LoginResponse toLoginResponse(User user);


    User toNewUserEntity(NewUserDto newUserDto);
}