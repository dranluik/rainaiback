package ee.valiit.rainaiback.business.video;

import ee.valiit.rainaiback.business.video.dto.VideoDto;
import ee.valiit.rainaiback.domain.video.Video;
import ee.valiit.rainaiback.domain.video.VideoMapper;
import ee.valiit.rainaiback.domain.video.VideoRepository;
import ee.valiit.rainaiback.domain.lesson.Lesson;
import ee.valiit.rainaiback.domain.lesson.LessonService;
import ee.valiit.rainaiback.domain.video.VideoService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideosService {

    @Resource
    private LessonService lessonService;

    @Resource
    private VideoMapper videoMapper;
    @Resource
    private VideoService videoService;
    public void addNewVideo(VideoDto videoDto) {
        Lesson lesson = lessonService.getLessonBy(videoDto.getLessonId());
        Video video = videoMapper.toVideoEntity(videoDto);
        video.setLesson(lesson);
        videoService.saveVideo(video);

    }

    public void deleteVideo(Integer videoId) {
        videoService.deleteVideo(videoId);


    }
    public List<VideoDto> findVideos(Integer lessonId) {
        List<Video> videos = videoService.findVideos(lessonId);

        return videoMapper.toVideoDtos(videos);

    }
}
