package ee.valiit.back_vali_kuusk.domain.userrole.user.contact;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ContactService {

    @Resource
    public ContactRepository contactRepository;


    public void addContact(Contact contact) {
        contactRepository.save(contact);
    }
}
