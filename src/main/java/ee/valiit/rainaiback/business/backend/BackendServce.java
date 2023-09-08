package ee.valiit.rainaiback.business.backend;

import ee.valiit.rainaiback.domain.technology.Technology;
import ee.valiit.rainaiback.business.frontend.TechnologyDto;
import ee.valiit.rainaiback.domain.technology.TechnologyMapper;
import ee.valiit.rainaiback.domain.technology.TechnologyService;
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
