package ee.valiit.rainaiback.domain.lesson;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {
    @Query("select l from Lesson l where (l.technology.id = ?1 or ?1 = 0) and (l.technology.packageType.id = ?2 or ?2 = 0) and l.status = ?3")
    List<Lesson> findLessonsBy(Integer technologyId, Integer packageTypeId, String status);



}