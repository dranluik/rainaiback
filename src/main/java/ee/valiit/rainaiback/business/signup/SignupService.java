package ee.valiit.rainaiback.business.signup;

import ee.valiit.rainaiback.business.status.UserStatus;
import ee.valiit.rainaiback.domain.contact.Contact;
import ee.valiit.rainaiback.domain.contact.ContactService;
import ee.valiit.rainaiback.domain.contact.user.packagetype.PackageType;
import ee.valiit.rainaiback.domain.contact.user.packagetype.PackageTypeMapper;
import ee.valiit.rainaiback.domain.contact.user.packagetype.PackageTypeService;
import ee.valiit.rainaiback.domain.contact.user.User;
import ee.valiit.rainaiback.domain.contact.user.UserMapper;
import ee.valiit.rainaiback.domain.contact.user.UserService;
import ee.valiit.rainaiback.domain.contact.user.role.Role;
import ee.valiit.rainaiback.domain.contact.user.role.RoleService;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ee.valiit.rainaiback.domain.contact.ContactMapper;

import java.util.List;

@Service
public class SignupService {

    @Resource
    private PackageTypeService packageTypeService;

    @Resource
    private PackageTypeMapper packageTypeMapper;
    @Resource
    private RoleService roleService;
    @Resource
    private UserService userService;
    @Resource
    private UserMapper userMapper;
    @Resource
    private ContactMapper contactMapper;
    @Resource
    private ContactService contactService;

    public List<PackageTypeDto> getPackages() {

        List<PackageType> packageTypes = packageTypeService.getAllPackageTypes();
        return packageTypeMapper.toPackageTypeDtos(packageTypes);
    }

    @Transactional
    public void addNewUserAndContact(NewUserDto request) {
        User user = createAndSaveUser(request);
        createAndSaveContact(request, user);




    }

    private User createAndSaveUser(NewUserDto request) {
        User user = createUser(request);
        userService.saveUser(user);
        return user;
    }

    private User createUser(NewUserDto request) {
        PackageType packageType = packageTypeService.findPackageBy(request.getPackageTypeId());
        Role role = roleService.getCustomerRole();
        userService.confirmUsernameAvailability(request.getUsername());
        User user = userMapper.toNewUserEntity(request);
        user.setRole(role);
        user.setPackageType(packageType);
        user.setStatus(UserStatus.ACTIVE.getLetter());
        return user;
    }

    private void createAndSaveContact(NewUserDto request, User user) {
        Contact contact = createContact(request, user);
        contactService.saveContact(contact);
    }

    private Contact createContact(NewUserDto request, User user) {
        Contact contact = contactMapper.toNewContactEntity(request);
        contact.setUser(user);
        return contact;
    }
}
