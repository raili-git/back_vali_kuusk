package ee.valiit.back_vali_kuusk.product;

import ee.valiit.back_vali_kuusk.domain.product.Type;
import ee.valiit.back_vali_kuusk.domain.product.TypeDto;
import ee.valiit.back_vali_kuusk.domain.product.TypeMapper;
import ee.valiit.back_vali_kuusk.domain.product.TypeRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductService {

    @Resource
    private TypeRepository typeRepository;

    @Resource
    private TypeMapper typeMapper;

    public List<TypeDto> getAllTreeTypes() {
        List<Type> types = typeRepository.findAll();
        typeMapper.typesToTypeDtos(types);
        return null;

    }


}
