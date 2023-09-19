package ee.valiit.rainaiback.domain.lesson;

import ee.valiit.rainaiback.business.lesson.dto.*;
import ee.valiit.rainaiback.util.ContentConverter;
import org.mapstruct.*;
import org.mapstruct.Named;

import java.nio.charset.StandardCharsets;

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
    @Mapping(source = "technology.id", target = "technologyId")
    @Mapping(source = "packageType.id", target = "packageTypeId")
    EditorLessonDto toEditorLessonDto(Lesson lesson);


    @Mapping(source = "content", target = "editorContent", qualifiedByName = "getContentAsString")
    EditorContentResponse toEditorContentResponse(Lesson lesson);

    @Named("getContentAsString")
    static String getContentAsString(byte[] content) {
        return ContentConverter.getContentAsString(content);
    }
}