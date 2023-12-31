package ee.valiit.rainaiback.domain.lesson;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {
    @Query("select l from Lesson l where (l.technology.id = ?1 or ?1 = 0) and (l.packageType.id = ?2 or ?2 = 0) and l.status = ?3")
    List<Lesson> findLessonsBy(Integer technologyId, Integer packageTypeId, String status);

    @Query("select (count(l) > 0) from Lesson l where l.name = ?1")
    boolean lessonNameExists(String lessonName);

    @Transactional
    @Modifying
    @Query("update Lesson l set l.content = ?1 where l.id = ?2")
    void updateContent(byte[] content, Integer id);

}