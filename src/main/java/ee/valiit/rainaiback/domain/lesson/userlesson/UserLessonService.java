package ee.valiit.rainaiback.domain.lesson.userlesson;

import ee.valiit.rainaiback.business.status.Status;
import ee.valiit.rainaiback.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLessonService {
    @Resource
    private UserLessonRepository userLessonRepository;


    public List<UserLesson> findUserLessonsBy(Integer userId) {
        List<UserLesson> userLessons = userLessonRepository.findAllUserLessonsBy(userId, Status.ACTIVE.getLetter());
        return userLessons;

    }
    public List<UserLesson> findUserLessonsAndValidateBy(Integer userId) {
        List<UserLesson> userLessons = userLessonRepository.findAllUserLessonsBy(userId, Status.ACTIVE.getLetter());
        ValidationService.validateAtLeastOneUserLessonExits(userLessons);
        return userLessons;

    }

    public void saveLesson(UserLesson userLesson) {
        userLessonRepository.save(userLesson);
    }

    public UserLesson findUserLessonBy(Integer userId, Integer lessonId) {
       return userLessonRepository.findUserLessonBy(userId,lessonId);
    }

    public void deleteLesson(UserLesson userLesson) {
        userLessonRepository.delete(userLesson);
    }
}
