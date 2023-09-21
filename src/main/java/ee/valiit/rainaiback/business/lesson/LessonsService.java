package ee.valiit.rainaiback.business.lesson;

import ee.valiit.rainaiback.business.lesson.dto.*;
import ee.valiit.rainaiback.business.status.Status;

import ee.valiit.rainaiback.domain.contact.user.packagetype.PackageType;
import ee.valiit.rainaiback.domain.contact.user.packagetype.PackageTypeService;
import ee.valiit.rainaiback.business.lesson.dto.ContentLessonDto;
import ee.valiit.rainaiback.domain.lesson.Lesson;
import ee.valiit.rainaiback.domain.lesson.LessonMapper;
import ee.valiit.rainaiback.domain.lesson.LessonService;
import ee.valiit.rainaiback.domain.technology.Technology;
import ee.valiit.rainaiback.domain.technology.TechnologyService;
import ee.valiit.rainaiback.util.ContentConverter;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


@Service
public class LessonsService {
    @Resource
    private TechnologyService technologyService;

    @Resource
    private LessonService lessonService;


    @Resource
    private LessonMapper lessonMapper;

    @Resource
    private PackageTypeService packageTypeService;



    public AddLessonResponse addNewLessonAndReturnId(AddLessonDto request) {
        lessonService.confirmNameAvailability(request.getLessonName());
        PackageType packageType = packageTypeService.findPackageBy(request.getPackageTypeId());
        Technology technology = technologyService.findTechnologyBy(request.getTechnologyId());

        Lesson lesson = lessonMapper.toLessonEntity(request);
        lesson.setPackageType(packageType);
        lesson.setTechnology(technology);
        lesson.setStatus(Status.DELETED.getLetter());
        lessonService.saveLesson(lesson);
        return new AddLessonResponse(lesson.getId());
    }

    public void updateLesson(ChangeLessonDto request) {
        Lesson lesson = lessonService.getLessonBy(request.getLessonId());
        handleLessonNameUpdate(request, lesson);
        handlePackageTypeUpdate(request, lesson);
        handleTechnologyUpdate(request, lesson);
        lessonService.saveLesson(lesson);
    }

    public void updateContent(ContentLessonDto request) {
        Integer lessonId = request.getLessonId();
        String content = request.getContent();
        if (content != null && !content.isEmpty()){
            byte[] lessonContent = ContentConverter.getBytesArrayFromContent(content);
            lessonService.updateContent(lessonContent, lessonId);
        }

    }


    public EditorContentResponse getEditorContent(Integer lessonId) {
        Lesson lesson = lessonService.getLessonBy(lessonId);
        return lessonMapper.toEditorContentResponse(lesson);
    }

    public EditorLessonDto getLessonInfo(Integer lessonId) {
        Lesson lesson = lessonService.getLessonBy(lessonId);
        return lessonMapper.toEditorLessonDto(lesson);
    }

    private void handleLessonNameUpdate(ChangeLessonDto request, Lesson lesson) {
        String lessonName = request.getLessonName();
        if (!lessonName.equals(lesson.getName())){
            lessonMapper.partialUpdateLessonName(request, lesson);
        }
    }

    private void handleTechnologyUpdate(ChangeLessonDto request, Lesson lesson) {
        Integer technologyId = request.getTechnologyId();
        if (!technologyId.equals(lesson.getTechnology().getId())){
            Technology technology = technologyService.findTechnologyBy(technologyId);
            lesson.setTechnology(technology);
        }
    }

    private void handlePackageTypeUpdate(ChangeLessonDto request, Lesson lesson) {
        Integer packageTypeId = request.getPackageTypeId();
        if (!packageTypeId.equals(lesson.getPackageType().getId())){
            PackageType packageType = packageTypeService.findPackageBy(packageTypeId);
            lesson.setPackageType(packageType);
        }
    }
}

