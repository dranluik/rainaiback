package ee.valiit.rainaiback.business.lesson.dto;

import ee.valiit.rainaiback.domain.lesson.Lesson;
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
public class EditorContentResponse implements Serializable {
    private String editorContent;
}