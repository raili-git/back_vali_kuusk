package ee.valiit.back_vali_kuusk.domain.order.order;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderService {
    @Resource
    private OrderRepository orderRepository;

    public void addOrder(Order order) {
        orderRepository.save(order);
    }

    public Order findOrderBy(Integer orderId) {
       return orderRepository.findById(orderId).get();
    }
}
