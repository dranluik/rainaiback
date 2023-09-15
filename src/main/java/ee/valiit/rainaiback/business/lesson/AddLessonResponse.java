package ee.valiit.rainaiback.business.lesson;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import ee.valiit.rainaiback.domain.lesson.Lesson;

/**
 * DTO for {@link Lesson}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddLessonResponse implements Serializable {
    private Integer lessonId;

}
