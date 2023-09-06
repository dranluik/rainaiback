package ee.valiit.rainaiback.business;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SignUpController {
    @Resource
    private SignUpService signUpService;

    @GetMapping("/signup")
    public List<PackageTypeDto> getPackages(){
        return signUpService.getPackages();
    }
}
