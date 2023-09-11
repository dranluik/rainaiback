package ee.valiit.rainaiback.business.frontend;

import ee.valiit.rainaiback.domain.lesson.Lesson;
import ee.valiit.rainaiback.business.lesson.LessonDto;
import ee.valiit.rainaiback.domain.lesson.LessonMapper;
import ee.valiit.rainaiback.domain.lesson.LessonService;
import ee.valiit.rainaiback.domain.lesson.userlesson.UserLesson;
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
    private LessonMapper lessonMapper;
    @Resource
    private UserLessonService userLessonService;

    public List<TechnologyDto> findAllActiveTechnologies(Integer packageTypeId) {
        List<Technology> technologies = technologyService.findTechnologiesBy(packageTypeId);
        return technologyMapper.toTechnologyDtos(technologies);
    }

    public List<LessonDto> getLessons(Integer userId, Integer packageTypeId, Integer technologyId) {
        List<Lesson> lessons = lessonService.getLessonsBy(packageTypeId, technologyId);
        List<UserLesson> userLessons = userLessonService.findUserLessonsBy(userId);
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

