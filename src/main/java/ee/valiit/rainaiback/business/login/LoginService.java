package ee.valiit.rainaiback.business.login;

import ee.valiit.rainaiback.domain.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Resource
    private UserService userService;


    public void login (String username, String password){

    }
}
