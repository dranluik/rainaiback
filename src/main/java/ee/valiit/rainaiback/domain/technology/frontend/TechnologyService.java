package ee.valiit.rainaiback.domain.technology.frontend;

import ee.valiit.rainaiback.business.status.UserStatus;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyService {

    @Resource
    private TechnologyRepository technologyRespository;

    public void findTechnologiesBy() {
        List<Technology> technologies = technologyRespository.findTechnologiesBy(UserStatus.ACTIVE.getLetter());
        ;
    }

}
