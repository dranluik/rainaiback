package ee.valiit.rainaiback.business.video;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoDto implements Serializable {

    private Integer lessonId;
    private String link;

}
