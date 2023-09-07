package ee.valiit.rainaiback.domain.contact.user.packagetype;

import ee.valiit.rainaiback.business.signup.PackageTypeDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PackageTypeMapper {
    @Mapping(source = "id", target = "packageId")
    @Mapping(source = "name", target = "packageName")
    @Mapping(source = "price", target = "packagePrice")
    PackageTypeDto toPackageTypeDto(PackageType packageType);

    List<PackageTypeDto> toPackageTypeDtos(List<PackageType> packageTypes);

}