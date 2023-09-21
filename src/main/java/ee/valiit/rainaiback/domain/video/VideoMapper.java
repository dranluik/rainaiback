package ee.valiit.rainaiback.domain.video;

import ee.valiit.rainaiback.business.video.dto.VideoDto;
import ee.valiit.rainaiback.domain.video.Video;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface VideoMapper {

    @Mapping(source = "lesson.id", target = "lessonId")
    @Mapping(source = "id", target = "videoId")
    VideoDto toVideoDto(Video video);

    List<VideoDto> toVideoDtos(List<Video> video);

    @Mapping(source = "videoLink", target = "link")
    @Mapping(source = "videoDescription", target = "description")
    Video toVideoEntity(VideoDto videoDto);
}