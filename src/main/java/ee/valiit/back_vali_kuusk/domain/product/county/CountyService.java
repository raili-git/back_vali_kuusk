package ee.valiit.back_vali_kuusk.domain.product.county;

import ee.valiit.back_vali_kuusk.business.user.ProfileRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CountyService {

    @Resource
    public CountyRepository countyRepository;

    public County findCountyById(ProfileRequest request) {
        return countyRepository.findById(request.getAddressCountyId()).get();
    }

    public County findCountyBy(Integer countyId) {
       return countyRepository.findById(countyId).get();

    }
}
