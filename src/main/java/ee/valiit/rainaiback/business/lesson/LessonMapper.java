package ee.valiit.rainaiback.business.lesson;

import ee.valiit.rainaiback.domain.lesson.Lesson;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface LessonMapper {
    Lesson toEntity(AddLessonDto addLessonDto);

    AddLessonDto toDto(Lesson lesson);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Lesson partialUpdate(AddLessonDto addLessonDto, @MappingTarget Lesson lesson);
}