package ee.valiit.rainaiback.domain.technology.backend;

import ee.valiit.rainaiback.domain.technology.frontend.Technology;
import ee.valiit.rainaiback.domain.technology.frontend.TechnologyDto;
import ee.valiit.rainaiback.domain.technology.frontend.TechnologyMapper;
import ee.valiit.rainaiback.domain.technology.frontend.TechnologyService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BackendServce {
    @Resource
    private TechnologyService technologyService;

    @Resource
    private TechnologyMapper technologyMapper;
    public List<TechnologyDto> findAllActiveTechnologies() {
        List<Technology> technologies = technologyService.findBackTechnologiesBy();
        return technologyMapper.toTechnologyDtos(technologies);
    }
}
