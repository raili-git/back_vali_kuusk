package ee.valiit.back_vali_kuusk.business.user;

import ee.valiit.back_vali_kuusk.domain.product.county.County;
import ee.valiit.back_vali_kuusk.domain.product.county.CountyService;
import ee.valiit.back_vali_kuusk.domain.userrole.user.address.Address;
import ee.valiit.back_vali_kuusk.domain.userrole.user.address.AddressService;
import ee.valiit.back_vali_kuusk.domain.userrole.user.contact.Contact;
import ee.valiit.back_vali_kuusk.domain.userrole.user.contact.ContactMapper;
import ee.valiit.back_vali_kuusk.domain.userrole.user.contact.ContactService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProfileService {

    @Resource
    public ContactService contactService;
    @Resource
    public CountyService countyService;
    @Resource
    public AddressService addressService;

    @Resource
    private ContactMapper contactMapper;

    public void addProfileInfo(ProfileRequest request) {
        County county = countyService.findCountyById(request);
        Address address = addressService.addAddress(request, county);
        Contact contact = contactMapper.toContact(request);
        contact.setAddress(address);
        contactService.addContact(contact);
    }

}
