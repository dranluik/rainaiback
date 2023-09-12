package ee.valiit.rainaiback.domain.lesson.userlesson;

import ee.valiit.rainaiback.business.lesson.UserLessonLessonNameDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserLessonMapper {


    @Mapping(source = "lesson.name", target = "lessonName")
    @Mapping(source = "lesson.id", target = "lessonId")
    UserLessonLessonNameDto toUserLessonLessonNameDto(UserLesson userLesson);

    List<UserLessonLessonNameDto> toUserLessonLessonNameDtos(List<UserLesson> userLessons);

    @Mapping(source = "lessonName", target = "lesson.name")
    UserLesson toNewUserLessonEntity(UserLessonDto userLessonDto);
}