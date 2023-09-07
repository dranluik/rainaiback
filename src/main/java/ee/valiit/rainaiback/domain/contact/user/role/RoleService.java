package ee.valiit.rainaiback.domain.contact.user.role;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Resource
    private RoleRepository roleRepository;
    public Role getCustomerRole(){
        return roleRepository.getReferenceById(2);


    }
}

