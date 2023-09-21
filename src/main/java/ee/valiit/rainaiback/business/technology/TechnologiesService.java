package ee.valiit.rainaiback.business.technology;

import ee.valiit.rainaiback.business.technology.dto.TechnologyDto;
import ee.valiit.rainaiback.business.status.Status;
import ee.valiit.rainaiback.business.technology.dto.AddTechnologyRequest;
import ee.valiit.rainaiback.domain.contact.user.packagetype.PackageType;
import ee.valiit.rainaiback.domain.contact.user.packagetype.PackageTypeService;
import ee.valiit.rainaiback.domain.technology.Technology;
import ee.valiit.rainaiback.domain.technology.TechnologyMapper;
import ee.valiit.rainaiback.domain.technology.TechnologyService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologiesService {
    @Resource
    private PackageTypeService packageTypeService;
    @Resource
    private TechnologyService technologyService;
    @Resource
    private TechnologyMapper technologyMapper;
    public void addNewTechnology(AddTechnologyRequest request) {
        PackageType packageType = packageTypeService.findPackageBy(request.getPackageTypeId());
        technologyService.confirmNameAvailability(request.getTechnologyName());
        Technology technology = technologyMapper.toTechnologyEntity(request);
        technology.setPackageType(packageType);
        technology.setStatus(Status.ACTIVE.getLetter());
        technologyService.saveTechnology(technology);
    }

    public List<TechnologyDto> findAllActiveTechnologies(Integer packageTypeId) {
        List<Technology> technologies = technologyService.findTechnologiesBy(packageTypeId);
        return technologyMapper.toTechnologyDtos(technologies);
    }
}
