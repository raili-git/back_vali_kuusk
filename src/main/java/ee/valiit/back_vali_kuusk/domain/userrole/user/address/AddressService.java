package ee.valiit.back_vali_kuusk.domain.userrole.user.address;

import ee.valiit.back_vali_kuusk.business.user.ProfileRequest;
import ee.valiit.back_vali_kuusk.domain.product.county.County;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AddressService {
    @Resource
    public AddressRepository addressRepository;

    public Address addAddress(ProfileRequest request, County county) {
        Address address = new Address();
        address.setCounty(county);
        address.setStreet(request.getAddressStreet());
        addressRepository.save(address);
        return address;
    }

    public Address findAddressBy(Integer addressId) {
       return addressRepository.findById(addressId).get();
    }
}
