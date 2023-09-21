package ee.valiit.rainaiback.domain.video;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoService {
    @Resource
    private VideoRepository videoRepository;
    public void saveVideo(Video video) {
        videoRepository.save(video);
    }

    public void deleteVideo(Integer videoId) {
        videoRepository.deleteById(videoId);
    }

    public List<Video> findVideos(Integer lessonId) {
        return videoRepository.findVideosBy(lessonId);
    }
}
