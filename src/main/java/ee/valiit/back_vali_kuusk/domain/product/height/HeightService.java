package ee.valiit.back_vali_kuusk.domain.product.height;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class HeightService {

    @Resource
    private HeightRepository heightRepository;

    public Height findHeightBy(Integer heightId) {
       return heightRepository.findById(heightId).get();

    }
}
