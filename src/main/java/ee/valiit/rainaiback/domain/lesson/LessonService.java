package ee.valiit.rainaiback.domain.lesson;

import ee.valiit.rainaiback.business.status.LessonStatus;
import ee.valiit.rainaiback.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {

    @Resource
    private LessonRepository lessonRepository;
    public List<Lesson> getLessonNames(Integer technologyId) {
        List<Lesson> lessonNames = lessonRepository.findLessonsBy(technologyId,2, LessonStatus.ADD.getLetter());
        ValidationService.validateAtLeastOneLessonNameExits(lessonNames);
        return lessonNames;
    }
}
