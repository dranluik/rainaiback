package ee.valiit.rainaiback.validation;

import ee.valiit.rainaiback.domain.user.User;
import ee.valiit.rainaiback.infrastructure.exception.BusinessException;

import java.util.Optional;

public class ValidationService {
    public static User getValidUser(Optional<User> optionalUser) {
        if (optionalUser.isEmpty()){
            throw new BusinessException(Error.INCORRECT_CREDENTIALS.getMessage(), Error.INCORRECT_CREDENTIALS.getErrorCode());
        }
        return optionalUser.get();
    }

}
