package ee.valiit.rainaiback.business.image;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link ee.valiit.rainaiback.domain.image.Image}
 */
@Value
public class ImageRequest implements Serializable {
    Integer lessonId;
    @NotNull
    String imageData;
    @Size(max = 255)
    String imageDescription;
}