package ee.valiit.back_vali_kuusk.domain.product.product;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductService {

    @Resource
    public ProductRepository productRepository;

    @Resource
    public ProductMapper productMapper;


    public void save(Product product) {
        productRepository.save(product);
    }


    public List<Product> findTreesBy(Integer userId) {
        List<Product> products = productRepository.findTreesBy(userId, "A");
        return products;
    }

    public List<Product> findAll() {
        List<Product> products = productRepository.findAllByStatus("A");
        return products;
    }

    public List<Product> findTreesBy(Integer typeId, Integer heightId, Integer countyId) {
        List<Product> products = productRepository.findProductBy(typeId, heightId, countyId, "A");
        return products;
    }

    public Product findProductBy(Integer productId) {
       return productRepository.findById(productId).get();
    }
}
