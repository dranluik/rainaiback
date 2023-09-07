package ee.valiit.rainaiback.business.login;

import ee.valiit.rainaiback.domain.contact.user.User;
import ee.valiit.rainaiback.domain.contact.user.UserMapper;
import ee.valiit.rainaiback.domain.contact.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Resource
    private UserService userService;
    @Resource
    private UserMapper userMapper;


    public LoginResponse login (String username, String password){
        User user = userService.findActiveUserBy(username, password);
        LoginResponse loginResponse = userMapper.toLoginResponse(user);
        return loginResponse;
    }
}
