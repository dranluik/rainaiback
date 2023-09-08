package ee.valiit.rainaiback.domain.lesson;

import ee.valiit.rainaiback.business.status.LessonStatus;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {

    @Resource
    private LessonRepository lessonRepository;
    public List<Lesson> getLessonNames() {
        return lessonRepository.findLessonsBy(2, LessonStatus.ADD.getLetter());
    }
}
