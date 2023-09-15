package ee.valiit.rainaiback.domain.lesson;

import ee.valiit.rainaiback.business.status.Status;
import ee.valiit.rainaiback.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {

    @Resource
    private LessonRepository lessonRepository;
    public List<ee.valiit.rainaiback.domain.lesson.Lesson> getLessonsBy(Integer packageTypeId, Integer technologyId) {
        List<ee.valiit.rainaiback.domain.lesson.Lesson> lessonNames = lessonRepository.findLessonsBy(technologyId, packageTypeId, Status.ACTIVE.getLetter());
        ValidationService.validateAtLeastOneLessonNameExits(lessonNames);
        return lessonNames;
    }


    public ee.valiit.rainaiback.domain.lesson.Lesson getLessonBy(String lessonName) {
        return lessonRepository.findLessonBy(lessonName);
    }
}
