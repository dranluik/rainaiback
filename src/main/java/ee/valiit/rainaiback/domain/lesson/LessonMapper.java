package ee.valiit.rainaiback.domain.lesson;

import ee.valiit.rainaiback.business.lesson.ChangeLessonDto;
import ee.valiit.rainaiback.business.lesson.LessonDto;
import ee.valiit.rainaiback.business.lesson.AddLessonDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface LessonMapper {


    @Mapping(source = "name", target = "lessonName")
    LessonDto toLessonDto(Lesson lesson);

    List<LessonDto> toLessonDtos(List<Lesson> lessons);


    @Mapping(source = "lessonName", target = "name")
    Lesson toLessonEntity(AddLessonDto addLessonDto);

    @Mapping(source = "lessonName", target = "name")
    @Mapping(source = "technologyId", target = "technology.id")
    @Mapping(source = "packageTypeId", target = "packageType.id")
    @Mapping(source = "lessonId", target = "id")
    Lesson toEntity(ChangeLessonDto changeLessonDto);

    @InheritInverseConfiguration(name = "toEntity")
    ChangeLessonDto toDto(Lesson lesson);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "lessonName", target = "name")
    Lesson partialUpdateLessonName(ChangeLessonDto changeLessonDto, @MappingTarget Lesson lesson);
}