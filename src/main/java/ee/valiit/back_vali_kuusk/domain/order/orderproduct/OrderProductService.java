package ee.valiit.back_vali_kuusk.domain.order.orderproduct;

import ee.valiit.back_vali_kuusk.domain.order.order.Order;
import ee.valiit.back_vali_kuusk.domain.order.order.OrderService;
import ee.valiit.back_vali_kuusk.domain.product.product.Product;
import ee.valiit.back_vali_kuusk.domain.product.product.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderProductService {

    @Resource
    private OrderProductRepository orderProductRepository;

    @Resource
    private ProductService productService;

    @Resource
    private OrderService orderService;

    public OrderProduct createNewOrderProduct(Order order, Product product) {
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setOrder(order);
        orderProduct.setProduct(product);
        return orderProductRepository.save(orderProduct);

    }

    public List<Product> findOrderProductBy(Integer orderId) {
        List<OrderProduct> orderProducts = orderProductRepository.findAll(orderId);
        List<Product> products = new ArrayList<>();

        for (OrderProduct orderProduct : orderProducts) {
            Product id = orderProduct.getProduct();
            products.add(id);
        }
        return products;
    }

    public long getProductCount(Integer orderId) {
        long count = orderProductRepository.count(orderId);
        return count;

    }

    public void deleteTreeById(Integer productId) {
        orderProductRepository.deleteById(productId);
    }
}
