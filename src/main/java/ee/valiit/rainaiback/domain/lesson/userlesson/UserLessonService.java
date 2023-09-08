package ee.valiit.rainaiback.domain.lesson.userlesson;

import ee.valiit.rainaiback.business.status.Status;
import ee.valiit.rainaiback.business.status.UserLessonStatus;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLessonService {
    @Resource
    private UserLessonRepository userLessonRepository;

    public List<UserLesson> findUserChosenLessons(Integer userId) {
        return userLessonRepository.findAllUserLessonsBy(userId, Status.ACTIVE.getLetter(), UserLessonStatus.DISABLE.getLetter());

    }
}
