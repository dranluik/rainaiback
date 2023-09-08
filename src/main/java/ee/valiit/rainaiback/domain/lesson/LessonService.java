package ee.valiit.rainaiback.domain.lesson;

import ee.valiit.rainaiback.business.status.UserLessonStatus;
import ee.valiit.rainaiback.business.status.Status;
import ee.valiit.rainaiback.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {

    @Resource
    private LessonRepository lessonRepository;
    public List<Lesson> getLessonNamesByTechnologyId(Integer technologyId) {
        List<Lesson> lessonNames = lessonRepository.findLessonsBy(technologyId,2, Status.ACTIVE.getLetter());
        ValidationService.validateAtLeastOneLessonNameExits(lessonNames);
        return lessonNames;
    }


}
