package ee.valiit.rainaiback.domain.contact.user;

import ee.valiit.rainaiback.business.Status;
import ee.valiit.rainaiback.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;


    public User findActiveUserBy(String username, String password) {
        Optional<User> optionalUser = userRepository.findUserBy(username, password, Status.ACTIVE.getLetter());
        return ValidationService.getValidUser(optionalUser);
    }

    public void confirmUsernameAvailability(String username) {
        boolean usernameExists = userRepository.usernameExistsBy(username);
        ValidationService.validateUsernameIsAvailable(usernameExists);

    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
}
