package ee.valiit.rainaiback.domain.technology.frontend;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class TechnologyService {

    @Resource
    private TechnologyRepository technologyRespository;

    public Technology findTehnologyById () {
        return technologyRespository.getReferenceById();
    }

}
