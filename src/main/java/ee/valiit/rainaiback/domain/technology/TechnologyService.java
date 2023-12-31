package ee.valiit.rainaiback.domain.technology;

import ee.valiit.rainaiback.business.status.Status;
import ee.valiit.rainaiback.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyService {

    @Resource
    private TechnologyRepository technologyRepository;

    public List<Technology> findTechnologiesBy(Integer packageTypeId) {
        List<Technology> technologies = technologyRepository.findTechnologiesBy(packageTypeId, Status.ACTIVE.getLetter());
        ValidationService.validateAtLeastOneTechnologyExists(technologies);
        return technologies;
    }

        public List<Technology> findBackTechnologiesBy () {
            List<Technology> backTechnologies = technologyRepository.findTechnologiesBy(3, Status.ACTIVE.getLetter());
            ValidationService.validateAtLeastOneTechnologyExists(backTechnologies);
            return backTechnologies;

        }


    public void confirmNameAvailability(String technologyName) {
        boolean technologyNameExists = technologyRepository.existsByName(technologyName);
        ValidationService.validateTechnologyNameIsAvailable(technologyNameExists);
    }

    public void saveTechnology(Technology technology) {
        technologyRepository.save(technology);
    }

    public Technology findTechnologyBy(Integer technologyId) {
        return technologyRepository.getReferenceById(technologyId);
    }
}
