package ee.valiit.rainaiback.business.lesson;

import ee.valiit.rainaiback.business.lesson.dto.*;
import ee.valiit.rainaiback.business.status.Status;
import ee.valiit.rainaiback.domain.contact.user.User;
import ee.valiit.rainaiback.domain.contact.user.UserService;
import ee.valiit.rainaiback.domain.contact.user.packagetype.PackageType;
import ee.valiit.rainaiback.domain.contact.user.packagetype.PackageTypeService;
import ee.valiit.rainaiback.domain.lesson.Lesson;
import ee.valiit.rainaiback.domain.lesson.LessonMapper;
import ee.valiit.rainaiback.domain.lesson.LessonService;
import ee.valiit.rainaiback.domain.lesson.userlesson.UserLesson;
import ee.valiit.rainaiback.domain.lesson.userlesson.UserLessonDto;
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

    @Resource
    private LessonMapper lessonMapper;

    @Resource
    private PackageTypeService packageTypeService;

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
    public void addNewUserLesson(UserLessonDto request) {
        UserLesson userLesson = createUserLesson(request);
        userLessonService.saveLesson(userLesson);
    }

    private UserLesson createUserLesson(UserLessonDto request) {
        Lesson lesson = lessonService.getLessonBy(request.getLessonId());
        User user = userService.findUserBy(request.getUserId());
        return new UserLesson(user, lesson);
    }

    public void deleteUserLesson(Integer userId, Integer lessonId) {
        UserLesson userLesson = userLessonService.findUserLessonBy(userId, lessonId);
        userLessonService.deleteLesson(userLesson);
    }

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
        lessonMapper.partialUpdateLessonNamePackageTechnology(request,lesson);
        handlePackageTypeUpdate(request, lesson);
        handleTechnologyUpdate(request, lesson);
        lessonService.saveLesson(lesson);
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

    public EditorLessonDto getLessonInfo(Integer lessonId) {
        Lesson lesson = lessonService.getLessonBy(lessonId);
        return lessonMapper.toEditorLessonDto(lesson);
    }
}

