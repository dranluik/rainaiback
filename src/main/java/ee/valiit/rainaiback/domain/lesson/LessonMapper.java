package ee.valiit.rainaiback.domain.lesson;

import ee.valiit.rainaiback.business.lesson.LessonDto;
import ee.valiit.rainaiback.business.lesson.AddLessonDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface LessonMapper {


    @Mapping(source = "name", target = "lessonName")
    LessonDto toLessonDto(Lesson lesson);

    List<LessonDto> toLessonDtos(List<Lesson> lessons);


    @Mapping(source = "lessonName",target = "name")
    Lesson toLessonEntity(AddLessonDto addLessonDto);

}