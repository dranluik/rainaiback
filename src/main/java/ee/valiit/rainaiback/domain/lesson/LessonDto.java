package ee.valiit.rainaiback.domain.lesson;

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
    private Integer packageTypeId;
    @Size(max = 255)
    private String lessonName;
    private String lessonStatus;
}