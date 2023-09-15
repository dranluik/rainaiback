package ee.valiit.rainaiback.domain.technology;

import ee.valiit.rainaiback.business.lesson.TechnologyDto;
import ee.valiit.rainaiback.business.lesson.AddLessonDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface TechnologyMapper {

    @Mapping(source = "id", target = "technologyId")
    TechnologyDto toTechnologyDto(Technology technology);

    List<TechnologyDto> toTechnologyDtos(List<Technology> technologies);

    @Mapping(source = "technologyName", target = "name")
    Technology toTechnologyEntity(AddLessonDto addLessonDto);

}