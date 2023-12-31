package ee.valiit.rainaiback.domain.lesson.userlesson;

import ee.valiit.rainaiback.domain.lesson.userlesson.UserLesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserLessonRepository extends JpaRepository<UserLesson, Integer> {
    @Query("select u from UserLesson u where u.user.id = ?1 and u.lesson.status = ?2")
    List<UserLesson> findAllUserLessonsBy(Integer id, String status);

    @Query("select u from UserLesson u where u.user.id = ?1 and u.lesson.id = ?2")
    UserLesson findUserLessonBy(Integer userId, Integer lessonId);




}