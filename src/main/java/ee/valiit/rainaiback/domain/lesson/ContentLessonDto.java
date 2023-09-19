package ee.valiit.rainaiback.domain.lesson;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;

/**
 * DTO for {@link Lesson}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContentLessonDto implements Serializable {
    private Integer lessonId;
    private String content;
}