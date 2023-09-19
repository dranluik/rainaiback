package ee.valiit.rainaiback.business.lesson.dto;

import ee.valiit.rainaiback.domain.lesson.userlesson.UserLesson;
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
public class UserLessonLessonNameDto implements Serializable {
    private String lessonName;
    private Integer lessonId;
}