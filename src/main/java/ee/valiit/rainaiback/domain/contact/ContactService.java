package ee.valiit.rainaiback.domain.contact;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    @Resource
    private ContactRepository contactRepository;
    public void saveContact(Contact contact) {
        contactRepository.save(contact);

    }
}
