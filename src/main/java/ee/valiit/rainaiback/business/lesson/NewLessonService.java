package ee.valiit.rainaiback.business.lesson;

import ee.valiit.rainaiback.domain.lesson.Lesson;
import ee.valiit.rainaiback.domain.lesson.LessonService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class NewLessonService {
    @Resource
    private NewLessonRepository newLessonRepository;

    public void saveLesson(LessonService lessonService) {
        NewLessonRepository.save(lessonService);
    }
}
