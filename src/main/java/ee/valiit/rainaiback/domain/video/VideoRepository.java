package ee.valiit.rainaiback.domain.video;

import ee.valiit.rainaiback.domain.video.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video, Integer> {

}