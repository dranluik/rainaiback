package ee.valiit.rainaiback.business;

import ee.valiit.rainaiback.domain.packagetype.PackageType;
import ee.valiit.rainaiback.domain.packagetype.PackageTypeMapper;
import ee.valiit.rainaiback.domain.packagetype.PackageTypeService;
import ee.valiit.rainaiback.domain.user.role.RoleService;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SignupService {

    @Resource
    private PackageTypeService packageTypeService;

    @Resource
    private PackageTypeMapper packageTypeMapper;
    @Resource
    private RoleService roleService;

    public List<PackageTypeDto> getPackages() {

        List<PackageType> packageTypes = packageTypeService.getAllPackageTypes();
        return packageTypeMapper.toPackageTypeDtos(packageTypes);
    }

    @Transactional
    public void addNewUser(NewUserDto request) {
        PackageType packageType = packageTypeService.findPackageBy(request.getPackageTypeId());
        roleService.findRoleBy();



    }
}
