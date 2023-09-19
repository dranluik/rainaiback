package ee.valiit.rainaiback.business.lesson.dto;

import ee.valiit.rainaiback.domain.lesson.Lesson;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Lesson}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditorLessonDto implements Serializable {
    private String packageTypeName;
    private String technologyName;
    private Integer packageTypeId;
    private Integer technologyId;
    @NotNull
    @Size(max = 255)
    private String lessonName;
}