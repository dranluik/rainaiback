package ee.valiit.rainaiback.business.frontend;

import ee.valiit.rainaiback.domain.lesson.Lesson;
import ee.valiit.rainaiback.business.lesson.LessonDto;
import ee.valiit.rainaiback.domain.lesson.LessonMapper;
import ee.valiit.rainaiback.domain.lesson.LessonService;
import ee.valiit.rainaiback.domain.technology.Technology;
import ee.valiit.rainaiback.domain.technology.TechnologyMapper;
import ee.valiit.rainaiback.domain.technology.TechnologyService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FrontendService {
    @Resource
    private TechnologyService technologyService;

    @Resource
    private LessonService lessonService;

    @Resource
    private TechnologyMapper technologyMapper;

    @Resource
    private LessonMapper lessonMapper;

    public List<TechnologyDto> findAllActiveTechnologies() {
        List<Technology> technologies = technologyService.findTechnologiesBy();
        return technologyMapper.toTechnologyDtos(technologies);
    }

    public List<LessonDto> getLessonName(Integer technologyId) {
        List<Lesson> lessonNames = lessonService.getLessonNamesByTechnologyId(technologyId);
        return lessonMapper.toLessonDtos(lessonNames);
    }
}
