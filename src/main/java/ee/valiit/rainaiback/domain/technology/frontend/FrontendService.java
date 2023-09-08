package ee.valiit.rainaiback.domain.technology.frontend;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FrontendService {
    @Resource
    private TechnologyService technologyService;

    @Resource
    private TechnologyMapper technologyMapper;
    public List<TechnologyDto> findAllActiveTechnologies() {
        List<Technology> technologies = technologyService.findTechnologiesBy();
        return technologyMapper.toTechnologyDtos(technologies);
    }
}
