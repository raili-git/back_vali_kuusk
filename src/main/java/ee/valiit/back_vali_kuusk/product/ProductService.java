package ee.valiit.back_vali_kuusk.product;

import ee.valiit.back_vali_kuusk.domain.product.height.Height;
import ee.valiit.back_vali_kuusk.domain.product.height.HeightDto;
import ee.valiit.back_vali_kuusk.domain.product.height.HeightMapper;
import ee.valiit.back_vali_kuusk.domain.product.height.HeightRepository;
import ee.valiit.back_vali_kuusk.domain.product.type.Type;
import ee.valiit.back_vali_kuusk.domain.product.type.TypeDto;
import ee.valiit.back_vali_kuusk.domain.product.type.TypeMapper;
import ee.valiit.back_vali_kuusk.domain.product.type.TypeRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductService {

    @Resource
    private TypeRepository typeRepository;

    @Resource
    private HeightRepository heightRepository;


    @Resource
    private TypeMapper typeMapper;

    @Resource
    private HeightMapper heightMapper;


    public List<TypeDto> getAllTreeTypes() {
        List<Type> types = typeRepository.findAll();
        List<TypeDto> typeDtos = typeMapper.typesToTypeDtos(types);
        return typeDtos;
    }
    public List<HeightDto> getAllTreeHeights() {
        List<Height> heights = heightRepository.findAll();
        List<HeightDto> heightDtos = heightMapper.heightsToHeightDtos(heights);
        return heightDtos;
    }


}
