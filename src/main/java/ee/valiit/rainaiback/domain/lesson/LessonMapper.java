package ee.valiit.rainaiback.domain.lesson;

import ee.valiit.rainaiback.business.lesson.dto.AddLessonDto;
import ee.valiit.rainaiback.business.lesson.dto.ChangeLessonDto;
import ee.valiit.rainaiback.business.lesson.dto.EditorLessonDto;
import ee.valiit.rainaiback.business.lesson.dto.LessonDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface LessonMapper {

    @Mapping(source = "name", target = "lessonName")
    LessonDto toLessonDto(Lesson lesson);

    @Mapping(source = "lessonName", target = "name")
    Lesson toLessonEntity(AddLessonDto addLessonDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "lessonName", target = "name")
    Lesson partialUpdateLessonName(ChangeLessonDto changeLessonDto, @MappingTarget Lesson lesson);

    @Mapping(source = "name", target = "lessonName")
    @Mapping(source = "technology.name", target = "technologyName")
    @Mapping(source = "packageType.name", target = "packageTypeName")
    EditorLessonDto toEditorLessonDto(Lesson lesson);
}