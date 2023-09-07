package ee.valiit.rainaiback.domain.contact.user.packagetype;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageTypeService {
    @Resource
    private PackageTypeRepository packageTypeRepository;

    public List<PackageType> getAllPackageTypes() {
        return packageTypeRepository.findAll();
    }

    public PackageType findPackageBy(Integer packageTypeId) {
        return packageTypeRepository.getReferenceById(packageTypeId);
    }
}
