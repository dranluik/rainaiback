package ee.valiit.rainaiback.domain.video;

import ee.valiit.rainaiback.domain.video.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Integer> {
    @Query("select v from Video v where v.lesson.id = ?1")
    List<Video> findVideosBy(Integer id);

}