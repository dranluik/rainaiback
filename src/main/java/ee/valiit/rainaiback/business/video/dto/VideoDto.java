package ee.valiit.rainaiback.business.video.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoDto implements Serializable {

    private Integer videoId;
    private Integer lessonId;
    private String videoLink;
    private String videoDescription;


}
