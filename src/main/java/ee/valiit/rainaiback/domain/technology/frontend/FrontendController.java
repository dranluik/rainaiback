package ee.valiit.rainaiback.domain.technology.frontend;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FrontendController {
    @Resource
    private FrontendService frontendService;

    @GetMapping("/frontend")
    public List<TechnologyDto> findAllActiveTechnologies() {
    List<TechnologyDto> technologies = frontendService.findAllActiveTechnologies();
    return technologies;
    }
}
