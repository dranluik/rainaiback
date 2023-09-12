package ee.valiit.rainaiback.business.lesson;

import ee.valiit.rainaiback.domain.contact.user.UserService;
import ee.valiit.rainaiback.domain.lesson.Lesson;
import ee.valiit.rainaiback.domain.lesson.LessonService;
import ee.valiit.rainaiback.domain.lesson.userlesson.UserLesson;
import ee.valiit.rainaiback.domain.lesson.userlesson.UserLessonMapper;
import ee.valiit.rainaiback.domain.lesson.userlesson.UserLessonService;
import ee.valiit.rainaiback.domain.technology.Technology;
import ee.valiit.rainaiback.domain.technology.TechnologyMapper;
import ee.valiit.rainaiback.domain.technology.TechnologyService;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LessonsService {
    @Resource
    private TechnologyService technologyService;

    @Resource
    private LessonService lessonService;

    @Resource
    private TechnologyMapper technologyMapper;

    @Resource
    private UserLessonMapper userLessonMapper;
    @Resource
    private UserLessonService userLessonService;

    @Resource
    private UserService userService;

    public List<TechnologyDto> findAllActiveTechnologies(Integer packageTypeId) {
        List<Technology> technologies = technologyService.findTechnologiesBy(packageTypeId);
        return technologyMapper.toTechnologyDtos(technologies);
    }

    public List<LessonDto> getLessons(Integer userId, Integer packageTypeId, Integer technologyId) {
        List<Lesson> lessons = lessonService.getLessonsBy(packageTypeId, technologyId);
        List<UserLesson> userLessons = userLessonService.findUserLessonsBy(userId);
        return createAndSaveLessonDtos(lessons, userLessons);

    }


    public List<UserLessonLessonNameDto> findMyLessons(Integer userId) {

        List<UserLesson> userLessons = userLessonService.findUserLessonsAndValidateBy(userId);
        return userLessonMapper.toUserLessonLessonNameDtos(userLessons);


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

    @Transactional
    public Lesson addNewUserLesson(UserLessonLessonNameDto request) {
        Lesson lesson = lessonService.getLessonBy(request.getLessonName());
//        userService.findUserBy(request.)

        return lesson;

    }

}

