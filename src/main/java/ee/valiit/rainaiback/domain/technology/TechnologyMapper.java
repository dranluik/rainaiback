package ee.valiit.rainaiback.domain.technology;

import ee.valiit.rainaiback.business.frontend.TechnologyDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TechnologyMapper {

    @Mapping(source = "packageType.id", target = "packageTypeId")
    TechnologyDto toTechnologyDto(Technology technology);

    List<TechnologyDto> toTechnologyDtos(List<Technology> technologies);

}