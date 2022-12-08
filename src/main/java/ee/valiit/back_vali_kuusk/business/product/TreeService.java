package ee.valiit.back_vali_kuusk.business.product;

import ee.valiit.back_vali_kuusk.domain.product.county.*;
import ee.valiit.back_vali_kuusk.domain.product.height.*;
import ee.valiit.back_vali_kuusk.domain.product.product.Product;
import ee.valiit.back_vali_kuusk.domain.product.product.ProductMapper;
import ee.valiit.back_vali_kuusk.domain.product.product.ProductService;
import ee.valiit.back_vali_kuusk.business.order.ShopResponse;
import ee.valiit.back_vali_kuusk.domain.product.type.*;
import ee.valiit.back_vali_kuusk.domain.userrole.user.User;
import ee.valiit.back_vali_kuusk.domain.userrole.user.UserService;
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
    private TypeMapper typeMapper;

    @Resource
    private HeightMapper heightMapper;

    @Resource
    private CountyMapper countyMapper;

    @Resource
    private ProductMapper productMapper;


    public List<TypeDto> getAllTreeTypes() {
        List<Type> types = typeService.findAll();
        List<TypeDto> typeDtos = typeMapper.typesToTypeDtos(types);
        return typeDtos;
    }
    public List<HeightDto> getAllTreeHeights() {
        List<Height> heights = heightService.findAll();
        List<HeightDto> heightDtos = heightMapper.heightsToHeightDtos(heights);
        return heightDtos;
    }

    public List<CountyDto> getAllCounties () {
        List<County> counties = countyService.findAll();
//        List<County> counties = countyRepository.findAll();
//      Siin muutsin ära selle, et ei läheks otse TreeService-st repository vastu, vaid see toimub domain osas countyServic-es
        List<CountyDto> countyDtos = countyMapper.countiesToCountyDtos(counties);
        return countyDtos;
    }


    public void addNewTree(NewTreeRequest request) {
        User user = userService.findUserBy(request.getUserId());
//        County county = countyService.findCountyBy(request.getCountyId());
        County county = user.getContact().getAddress().getCounty();
        Type type = typeService.findTypeBy(request.getTypeId());
        Height height = heightService.findHeightBy(request.getHeightId());

        Product product = productMapper.newTreeRequestToProduct(request);
        product.setUser(user);
        product.setCounty(county);
        product.setType(type);
        product.setHeight(height);
        productService.save(product);
    }


    public List<ProductResponse> getAllTreesByUserId(Integer userId) {
        List<Product> products = productService.findTreesBy(userId);
        List<ProductResponse> productsResponse = productMapper.productsToProductResponse(products);
        return productsResponse;


    }

    public List<ShopResponse> getAllTrees() {
        List<Product> products = productService.findAll();
        List<ShopResponse> productsToShopResponse = productMapper.productsToShopResponse(products);
        return productsToShopResponse;
    }

    public List<ShopResponse> getProductsBySortingParameters(Integer typeId, Integer heightId, Integer countyId) {
        List<Product> products = productService.findTreesBy(typeId, heightId, countyId);
        List<ShopResponse> productsToShopResponse = productMapper.productsToShopResponse(products);
        return productsToShopResponse;
    }
}
