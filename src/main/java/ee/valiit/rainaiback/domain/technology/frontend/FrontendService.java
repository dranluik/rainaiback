package ee.valiit.rainaiback.domain.technology.frontend;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class FrontendService {
    @Resource
    private TechnologyService technologyService;

    public void findAllActiveTehnologies() {
        technologyService.findTechnologiesBy();
    }
}
