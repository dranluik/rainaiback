package ee.valiit.rainaiback.business.lesson;

import ee.valiit.rainaiback.business.lesson.TechnologyDto;
import ee.valiit.rainaiback.domain.lesson.Lesson;
import ee.valiit.rainaiback.business.lesson.LessonDto;
import ee.valiit.rainaiback.domain.lesson.LessonMapper;
import ee.valiit.rainaiback.domain.lesson.LessonService;
import ee.valiit.rainaiback.domain.lesson.userlesson.UserLesson;
import ee.valiit.rainaiback.domain.lesson.userlesson.UserLessonMapper;
import ee.valiit.rainaiback.domain.lesson.userlesson.UserLessonService;
import ee.valiit.rainaiback.domain.technology.Technology;
import ee.valiit.rainaiback.domain.technology.TechnologyMapper;
import ee.valiit.rainaiback.domain.technology.TechnologyService;
import jakarta.annotation.Resource;
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

    public List<TechnologyDto> findAllActiveTechnologies(Integer packageTypeId) {
        List<Technology> technologies = technologyService.findTechnologiesBy(packageTypeId);
        return technologyMapper.toTechnologyDtos(technologies);
    }

    public List<LessonDto> getLessons(Integer userId, Integer packageTypeId, Integer technologyId) {
        List<Lesson> lessons = lessonService.getLessonsBy(packageTypeId, technologyId);
        List<UserLesson> userLessons = userLessonService.findUserLessonsBy(userId);
        return createAndSaveLessonDtos(lessons, userLessons);

    }


    public void findMyLessons(Integer userId) {

        List<UserLesson> userLessons = userLessonService.findUserLessonsBy(userId);


    }

    private static List<LessonDto> createAndSaveLessonDtos(List<Lesson> lessons, List<UserLesson> userLessons) {
        List<LessonDto> lessonDtos = new ArrayList<>();
        for (Lesson lesson : lessons) {
            LessonDto lessonDto = new LessonDto();
            lessonDto.setLessonName(lesson.getName());
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
}

