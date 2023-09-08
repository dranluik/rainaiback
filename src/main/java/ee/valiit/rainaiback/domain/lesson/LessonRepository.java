package ee.valiit.rainaiback.domain.lesson;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {
    @Query("select l from Lesson l where l.packageType.id = ?1 and l.status = ?2")
    List<Lesson> findLessonsBy(Integer id, String status);

}