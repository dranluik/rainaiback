package ee.valiit.rainaiback.domain.technology.frontend;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TechnologyMapper {

    @Mapping(source = "packageType.id", target = "packageTypeId")
    TechnologyDto toTechnologyDto(Technology technology);

    List<TechnologyDto> toTechnologyDtos(List<TechnologyDto> technologyDtos);
}