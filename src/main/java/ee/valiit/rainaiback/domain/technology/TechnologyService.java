package ee.valiit.rainaiback.domain.technology;

import ee.valiit.rainaiback.business.status.UserStatus;
import ee.valiit.rainaiback.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyService {

    @Resource
    private TechnologyRepository technologyRepository;

    public List<Technology> findTechnologiesBy() {
        List<Technology> technologies = technologyRepository.findTechnologiesBy(2, UserStatus.ACTIVE.getLetter());
        ValidationService.validateAtLeastOneTechnologyExists(technologies);
        return technologies;
    }

        public List<Technology> findBackTechnologiesBy () {
            List<Technology> backTechnologies = technologyRepository.findTechnologiesBy(3, UserStatus.ACTIVE.getLetter());
            ValidationService.validateAtLeastOneTechnologyExists(backTechnologies);
            return backTechnologies;

        }



}
