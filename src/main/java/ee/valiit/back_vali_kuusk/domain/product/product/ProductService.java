package ee.valiit.back_vali_kuusk.domain.product.product;

import ee.valiit.back_vali_kuusk.business.product.NewTreeRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProductService {

    @Resource
    public ProductRepository productRepository;

    @Resource
    public ProductMapper productMapper;


    public void save(Product product) {
        productRepository.save(product);
    }
}
