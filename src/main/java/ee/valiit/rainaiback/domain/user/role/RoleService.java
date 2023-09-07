package ee.valiit.rainaiback.domain.user.role;

import ee.valiit.rainaiback.business.Role;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Resource
    private RoleRepository roleRepository;
    public void findRoleBy(){
        roleRepository.findRoleBy();


    }
}

