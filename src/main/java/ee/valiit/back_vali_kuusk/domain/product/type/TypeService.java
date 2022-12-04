package ee.valiit.back_vali_kuusk.domain.product.type;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TypeService {

    @Resource
    public TypeRepository typeRepository;

    public Type findTypeBy(Integer typeId) {
        return typeRepository.findById(typeId).get();

    }

    public List<Type> findAll() {
        List<Type> types = typeRepository.findAll();
        return types;

    }
}

