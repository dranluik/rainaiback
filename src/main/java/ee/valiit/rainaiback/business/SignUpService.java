package ee.valiit.rainaiback.business;

import ee.valiit.rainaiback.domain.packagetype.PackageType;
import ee.valiit.rainaiback.domain.packagetype.PackageTypeMapper;
import ee.valiit.rainaiback.domain.packagetype.PackageTypeService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignUpService {

    @Resource
    private PackageTypeService packageTypeService;

    @Resource
    private PackageTypeMapper packageTypeMapper;

    public List<PackageTypeDto> getPackages() {

        List<PackageType> packageTypes = packageTypeService.getAllPackageTypes();
        return packageTypeMapper.toPackageTypeDtos(packageTypes);
    }
}
