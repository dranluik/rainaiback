package ee.valiit.rainaiback.business.userlesson;

import ee.valiit.rainaiback.business.lesson.dto.LessonDto;
import ee.valiit.rainaiback.business.lesson.dto.UserLessonLessonNameDto;
import ee.valiit.rainaiback.domain.contact.user.User;
import ee.valiit.rainaiback.domain.contact.user.UserService;
import ee.valiit.rainaiback.domain.lesson.Lesson;
import ee.valiit.rainaiback.domain.lesson.LessonService;
import ee.valiit.rainaiback.domain.lesson.userlesson.UserLesson;
import ee.valiit.rainaiback.domain.lesson.userlesson.UserLessonDto;
import ee.valiit.rainaiback.domain.lesson.userlesson.UserLessonMapper;
import ee.valiit.rainaiback.domain.lesson.userlesson.UserLessonService;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserLessonsService {
    @Resource
    private LessonService lessonService;
    @Resource
    private UserLessonService userLessonService;
    @Resource
    private UserLessonMapper userLessonMapper;
    @Resource
    private UserService userService;

    public List<LessonDto> getLessons(Integer userId, Integer packageTypeId, Integer technologyId) {
        List<Lesson> lessons = lessonService.getLessonsBy(packageTypeId, technologyId);
        List<UserLesson> userLessons = userLessonService.findUserLessonsBy(userId);
        return createAndSaveLessonDtos(lessons, userLessons);
    }

    public List<UserLessonLessonNameDto> findMyLessons(Integer userId) {
        List<UserLesson> userLessons = userLessonService.findUserLessonsAndValidateBy(userId);
        return userLessonMapper.toUserLessonLessonNameDtos(userLessons);
    }
    @Transactional
    public void addNewUserLesson(UserLessonDto request) {
        UserLesson userLesson = createUserLesson(request);
        userLessonService.saveLesson(userLesson);
    }

    public void deleteUserLesson(Integer userId, Integer lessonId) {
        UserLesson userLesson = userLessonService.findUserLessonBy(userId, lessonId);
        userLessonService.deleteLesson(userLesson);
    }

    private static List<LessonDto> createAndSaveLessonDtos(List<Lesson> lessons, List<UserLesson> userLessons) {
        List<LessonDto> lessonDtos = new ArrayList<>();
        for (Lesson lesson : lessons) {
            LessonDto lessonDto = new LessonDto();
            lessonDto.setLessonName(lesson.getName());
            lessonDto.setLessonId(lesson.getId());
            lessonDto.setIsSelected(false);

            for (UserLesson userLesson : userLessons) {
                if (lesson.getId().equals(userLesson.getLesson().getId())) {
                    lessonDto.setIsSelected(true);
                    break;
                }
            }
            lessonDtos.add(lessonDto);
        }
        return lessonDtos;
    }

    private UserLesson createUserLesson(UserLessonDto request) {
        Lesson lesson = lessonService.getLessonBy(request.getLessonId());
        User user = userService.findUserBy(request.getUserId());
        return new UserLesson(user, lesson);
    }

}
