package ee.valiit.rainaiback.domain.contact.user.packagetype;

import ee.valiit.rainaiback.validation.ValidationService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageTypeService {
    @Resource
    private PackageTypeRepository packageTypeRepository;


    public List<PackageType> getAllPackageTypes() {

        List<PackageType> packageTypes = packageTypeRepository.findAll();
        ValidationService.validateAtLeastOnePackageExists(packageTypes);
        return packageTypes;
    }

    public PackageType findPackageBy(Integer packageTypeId) {
        return packageTypeRepository.getReferenceById(packageTypeId);
    }
}
