package ee.valiit.rainaiback.domain.packagetype;

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
}
