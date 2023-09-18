package ee.valiit.rainaiback.validation;

import ee.valiit.rainaiback.domain.contact.user.User;
import ee.valiit.rainaiback.domain.contact.user.packagetype.PackageType;
import ee.valiit.rainaiback.domain.lesson.Lesson;
import ee.valiit.rainaiback.domain.lesson.userlesson.UserLesson;
import ee.valiit.rainaiback.domain.technology.Technology;
import ee.valiit.rainaiback.infrastructure.exception.BusinessException;
import ee.valiit.rainaiback.infrastructure.exception.DataNotFoundException;

import java.util.List;
import java.util.Optional;

import static ee.valiit.rainaiback.validation.Error.*;

public class ValidationService {
    public static User getValidUser(Optional<User> optionalUser) {
        if (optionalUser.isEmpty()) {
            throw new BusinessException(INCORRECT_CREDENTIALS.getMessage(), INCORRECT_CREDENTIALS.getErrorCode());
        }
        return optionalUser.get();
    }

    public static void validateAtLeastOnePackageExists(List<PackageType> packageTypes) {
        if (packageTypes.isEmpty()) {
            throw new DataNotFoundException(NO_PACKAGE_FOUND.getMessage(), NO_PACKAGE_FOUND.getErrorCode());
        }
    }

    public static void validateUsernameIsAvailable(boolean usernameExists) {
        if (usernameExists) {
            throw new BusinessException(
                    USERNAME_UNAVAILABLE.getMessage(), USERNAME_UNAVAILABLE.getErrorCode()
            );
        }
    }

    public static void validateAtLeastOneTechnologyExists(List<Technology> technologies) {
        if (technologies.isEmpty()) {
            throw new DataNotFoundException(NO_TECHNOLOGIES_FOUND.getMessage(), NO_TECHNOLOGIES_FOUND.getErrorCode());
        }
    }


    public static void validateAtLeastOneLessonNameExits(List<Lesson> lessonNames) {
        if (lessonNames.isEmpty()) {
            throw new DataNotFoundException(NO_LESSON_NAMES_FOUND.getMessage(), NO_LESSON_NAMES_FOUND.getErrorCode());
        }
    }

    public static void validateAtLeastOneUserLessonExits(List<UserLesson> userLessons) {
        if (userLessons.isEmpty()) {
            throw new DataNotFoundException(NO_USER_LESSONS_FOUND.getMessage(), NO_USER_LESSONS_FOUND.getErrorCode());
        }
    }


    public static void validateTechnologyNameIsAvailable(boolean technologyNameExists) {
        if (technologyNameExists) {
            throw new BusinessException(
                    TECHNOLOGY_NAME_UNAVAILABLE.getMessage(), TECHNOLOGY_NAME_UNAVAILABLE.getErrorCode());
        }

    }

    public static void validateLessonNameIsAvailable(boolean lessonNameExists) {
        if (lessonNameExists) {
            throw new BusinessException(
                    LESSON_NAME_UNAVAILABLE.getMessage(), LESSON_NAME_UNAVAILABLE.getErrorCode()
            );
        }
    }
}
