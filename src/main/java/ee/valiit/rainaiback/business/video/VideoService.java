package ee.valiit.rainaiback.business.video;

import ee.valiit.rainaiback.domain.video.Video;
import ee.valiit.rainaiback.domain.video.VideoRepository;
import ee.valiit.rainaiback.domain.lesson.Lesson;
import ee.valiit.rainaiback.domain.lesson.LessonService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {

    @Resource
    private LessonService lessonService;

    @Resource
    private VideoRepository videoRepository;

    @Resource
    private VideoMapper videoMapper;
    public void addNewVideo(VideoDto videoDto) {
        Lesson lesson = lessonService.getLessonBy(videoDto.getLessonId());
        Video video = new Video();
        video.setLink(videoDto.getLink());
        video.setLesson(lesson);
        video.setDescription(videoDto.getDescription());
        videoRepository.save(video);
    }

    public void deleteVideo(Integer videoId) {
        videoRepository.deleteById(videoId);

    }
    public List<VideoDto> findVideos(Integer lessonId) {
        List<Video> videosBy = videoRepository.findVideosBy(lessonId);
        return videoMapper.toVideoDtos(videosBy);

    }
}
