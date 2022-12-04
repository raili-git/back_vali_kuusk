package ee.valiit.back_vali_kuusk.business.product;

import ee.valiit.back_vali_kuusk.domain.product.county.*;
import ee.valiit.back_vali_kuusk.domain.product.height.*;
import ee.valiit.back_vali_kuusk.domain.product.product.Product;
import ee.valiit.back_vali_kuusk.domain.product.product.ProductMapper;
import ee.valiit.back_vali_kuusk.domain.product.product.ProductService;
import ee.valiit.back_vali_kuusk.domain.product.type.*;
import ee.valiit.back_vali_kuusk.domain.userrole.user.User;
import ee.valiit.back_vali_kuusk.domain.userrole.user.UserService;
import ee.valiit.back_vali_kuusk.domain.userrole.user.address.Address;
import ee.valiit.back_vali_kuusk.domain.userrole.user.address.AddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TreeService {

    @Resource
    private ProductService productService;

    @Resource
    private TypeService typeService;

    @Resource
    private HeightService heightService;

    @Resource
    private UserService userService;

    @Resource
    private CountyService countyService;

    @Resource
    private AddressService addressService;


    @Resource
    private TypeRepository typeRepository;

    @Resource
    private HeightRepository heightRepository;

    @Resource
    private CountyRepository countyRepository;


    @Resource
    private TypeMapper typeMapper;

    @Resource
    private HeightMapper heightMapper;

    @Resource
    private CountyMapper countyMapper;

    @Resource
    private ProductMapper productMapper;


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

    public List<CountyDto> getAllCounties () {
        List<County> counties = countyRepository.findAll();
        List<CountyDto> countyDtos = countyMapper.countiesToCountyDtos(counties);
        return countyDtos;
    }


    public void addNewTree(NewTreeRequest request) {
        Product product = productMapper.newTreeRequestToProduct(request);
        product.setPrice(request.getProductPrice());
//        product.setImageData(request.getProductImage());
        product.setStatus("A");
        Type type = typeService.findTypeBy(request.getTypeId());
        product.setType(type);
        Height height = heightService.findHeightBy(request.getHeightId());
        product.setHeight(height);
        User user = userService.findUserBy(request.getUserId());
        product.setUser(user);
        County county = countyService.findCountyBy(request.getCountyId());
        product.setCounty(county);
        Address address = addressService.findAddressBy(request.getAddressId());
        product.setAddress(address);
        productService.save(product);

    }
}
