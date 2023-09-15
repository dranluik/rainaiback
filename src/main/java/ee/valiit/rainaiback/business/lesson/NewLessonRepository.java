package ee.valiit.rainaiback.business.lesson;

import ee.valiit.rainaiback.domain.lesson.Lesson;
import ee.valiit.rainaiback.domain.lesson.LessonService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewLessonRepository extends JpaRepository<Lesson, Integer> {
}