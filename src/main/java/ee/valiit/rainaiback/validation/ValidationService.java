package ee.valiit.rainaiback.validation;

import ee.valiit.rainaiback.domain.contact.user.User;
import ee.valiit.rainaiback.domain.contact.user.packagetype.PackageType;
import ee.valiit.rainaiback.infrastructure.exception.BusinessException;
import ee.valiit.rainaiback.infrastructure.exception.DataNotFoundException;

import java.util.List;
import java.util.Optional;

import static ee.valiit.rainaiback.validation.Error.*;

public class ValidationService {
    public static User getValidUser(Optional<User> optionalUser) {
        if (optionalUser.isEmpty()){
            throw new BusinessException(INCORRECT_CREDENTIALS.getMessage(), INCORRECT_CREDENTIALS.getErrorCode());
        }
        return optionalUser.get();
    }

    public static void validateAtLeastOnePackageExists(List<PackageType> packageTypes) {
        if(packageTypes.isEmpty()){
            throw new DataNotFoundException(NO_PACKAGE_FOUND.getMessage(), NO_PACKAGE_FOUND.getErrorCode());
        }
    }

    public static void validateUsernameIsAvailable(boolean usernameExists) {
        if(usernameExists) {
            throw new BusinessException(
                    USERNAME_UNAVAILABLE.getMessage(), USERNAME_UNAVAILABLE.getErrorCode()
            );
        }
    }
}
