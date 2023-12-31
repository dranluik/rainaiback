package ee.valiit.rainaiback.domain.contact;

import ee.valiit.rainaiback.business.signup.dto.NewUserDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ContactMapper {




    Contact toNewContactEntity(NewUserDto newUserDto);
}