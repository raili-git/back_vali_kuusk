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
        List<Product> products = productRepository.findTreesBy(userId);
        return products;
    }
}
