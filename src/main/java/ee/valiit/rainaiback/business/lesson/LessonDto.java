package ee.valiit.rainaiback.business.lesson;

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
public class LessonDto implements Serializable {

    @Size(max = 255)
    private String lessonName;
    @NotNull
    private Boolean isSelected;
    private Integer lessonId;
}