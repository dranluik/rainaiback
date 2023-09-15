package ee.valiit.rainaiback.domain.lesson.userlesson;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link UserLesson}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLessonDto implements Serializable {
    @NotNull
    private Integer userId;
    @NotNull
    private Integer lessonId;
}