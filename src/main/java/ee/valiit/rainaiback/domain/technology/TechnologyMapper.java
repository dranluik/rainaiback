package ee.valiit.rainaiback.domain.technology;

import ee.valiit.rainaiback.business.lesson.dto.TechnologyDto;
import ee.valiit.rainaiback.business.technology.AddTechnologyRequest;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TechnologyMapper {

    @Mapping(source = "id", target = "technologyId")
    TechnologyDto toTechnologyDto(Technology technology);

    List<TechnologyDto> toTechnologyDtos(List<Technology> technologies);

    @Mapping(source = "technologyName", target = "name")
    Technology toTechnologyEntity(AddTechnologyRequest addTechnologyRequest);

}