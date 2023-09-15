package ee.valiit.rainaiback.business.video;

import ee.valiit.rainaiback.Video;
import ee.valiit.rainaiback.VideoRepository;
import ee.valiit.rainaiback.domain.lesson.Lesson;
import ee.valiit.rainaiback.domain.lesson.LessonService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class VideoService {

    @Resource
    private LessonService lessonService;

    @Resource
    private VideoRepository videoRepository;

    public void addNewVideo(VideoDto videoDto) {
        Lesson lesson = lessonService.getLessonBy(videoDto.getLessonId());
        Video video = new Video();
        video.setLink(videoDto.getLink());
        video.setLesson(lesson);
        videoRepository.save(video);
    }
}
