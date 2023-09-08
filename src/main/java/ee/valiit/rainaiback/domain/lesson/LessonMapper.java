package ee.valiit.rainaiback.domain.lesson;

import ee.valiit.rainaiback.business.lesson.LessonDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface LessonMapper {

    @Mapping(source = "packageType.id", target = "packageTypeId")
    @Mapping(source = "status", target = "lessonStatus")
    @Mapping(source = "name", target = "lessonName")
    LessonDto toLessonDto(Lesson lesson);

    List<LessonDto> toLessonDtos(List<Lesson> lessons);
}