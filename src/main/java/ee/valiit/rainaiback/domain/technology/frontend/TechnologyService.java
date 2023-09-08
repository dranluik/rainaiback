package ee.valiit.rainaiback.domain.technology.frontend;

import ee.valiit.rainaiback.business.status.UserStatus;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyService {

    @Resource
    private TechnologyRepository technologyRepository;

    public List<Technology> findTechnologiesBy() {
        List<Technology> technologies = technologyRepository.findTechnologiesBy(UserStatus.ACTIVE.getLetter(),
                technologyRepository.getReferenceById(2));
        return technologies;

    }

}
