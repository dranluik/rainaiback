package ee.valiit.rainaiback.business.lesson.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link ee.valiit.rainaiback.domain.lesson.Lesson}, {@link ee.valiit.rainaiback.domain.technology.Technology}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddLessonDto implements Serializable {
    private Integer packageTypeId;
    private Integer technologyId;
    @NotNull
    @Size(max = 255)
    private String lessonName;
}