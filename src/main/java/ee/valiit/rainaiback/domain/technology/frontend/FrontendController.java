package ee.valiit.rainaiback.domain.technology.frontend;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FrontendController {
    @Resource
    private FrontendService frontendService;

    @GetMapping("/frontend")
    public void findAllActiveTechnologies() {
    frontendService.findAllActiveTehnologies();

    }
}
