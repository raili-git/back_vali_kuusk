package ee.valiit.back_vali_kuusk.domain.order.orderproduct;

import ee.valiit.back_vali_kuusk.domain.order.order.Order;
import ee.valiit.back_vali_kuusk.domain.product.product.Product;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderProductService {

    @Resource
    private OrderProductRepository orderProductRepository;

    public OrderProduct createNewOrderProduct(Order order, Product product) {
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setOrder(order);
        orderProduct.setProduct(product);
        return orderProductRepository.save(orderProduct);

    }
}
