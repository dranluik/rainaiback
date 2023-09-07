package ee.valiit.rainaiback.validation;

import ee.valiit.rainaiback.domain.contact.user.User;
import ee.valiit.rainaiback.infrastructure.exception.BusinessException;

import java.util.Optional;

import static ee.valiit.rainaiback.validation.Error.INCORRECT_CREDENTIALS;
import static ee.valiit.rainaiback.validation.Error.USERNAME_UNAVAILABLE;

public class ValidationService {
    public static User getValidUser(Optional<User> optionalUser) {
        if (optionalUser.isEmpty()){
            throw new BusinessException(INCORRECT_CREDENTIALS.getMessage(), INCORRECT_CREDENTIALS.getErrorCode());
        }
        return optionalUser.get();
    }

    public static void validateUsernameIsAvailable(boolean usernameExists) {
        if(usernameExists) {
            throw new BusinessException(
                    USERNAME_UNAVAILABLE.getMessage(), USERNAME_UNAVAILABLE.getErrorCode()
            );
        }
    }
}
