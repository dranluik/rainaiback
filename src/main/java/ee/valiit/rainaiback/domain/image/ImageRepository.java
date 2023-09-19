package ee.valiit.rainaiback.domain.image;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Integer> {
    @Query("select i from Image i where i.lesson.id = ?1")
    List<Image> findAllImagesBy(Integer id);


}