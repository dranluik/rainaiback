package ee.valiit.rainaiback.business.packagetype;


import ee.valiit.rainaiback.business.packagetype.dto.PackageTypeDto;
import ee.valiit.rainaiback.domain.contact.user.packagetype.PackageType;
import ee.valiit.rainaiback.domain.contact.user.packagetype.PackageTypeMapper;
import ee.valiit.rainaiback.domain.contact.user.packagetype.PackageTypeService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PackageTypesService {
    @Resource
    private PackageTypeService packageTypeService;

    @Resource
    private PackageTypeMapper packageTypeMapper;

    public List<PackageTypeDto> getPackages() {

        List<PackageType> packageTypes = packageTypeService.getAllPackageTypes();
        return packageTypeMapper.toPackageTypeDtos(packageTypes);
    }
}
