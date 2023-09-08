package ee.valiit.rainaiback.business.lesson;

import ee.valiit.rainaiback.domain.lesson.userlesson.UserLesson;
import ee.valiit.rainaiback.domain.lesson.userlesson.UserLessonMapper;
import ee.valiit.rainaiback.domain.lesson.userlesson.UserLessonService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyLessonService {
    @Resource
    private UserLessonService userLessonService;
    @Resource
    private UserLessonMapper userLessonMapper;

    public List<UserLessonLessonNameDto> findUserLessons(Integer userId) {
        List<UserLesson> userChosenLessons = userLessonService.findUserChosenLessons(userId);
        return userLessonMapper.toUserLessonLessonNameDtos(userChosenLessons);



    }
}
