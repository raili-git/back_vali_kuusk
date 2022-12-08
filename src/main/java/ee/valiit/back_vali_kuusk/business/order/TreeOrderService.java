package ee.valiit.back_vali_kuusk.business.order;

import ee.valiit.back_vali_kuusk.domain.order.order.Order;
import ee.valiit.back_vali_kuusk.domain.order.order.OrderService;
import ee.valiit.back_vali_kuusk.domain.order.delivery.Delivery;
import ee.valiit.back_vali_kuusk.domain.order.delivery.DeliveryService;
import ee.valiit.back_vali_kuusk.domain.order.orderproduct.OrderProductService;
import ee.valiit.back_vali_kuusk.domain.order.session.Session;
import ee.valiit.back_vali_kuusk.domain.order.session.SessionService;
import ee.valiit.back_vali_kuusk.domain.product.product.Product;
import ee.valiit.back_vali_kuusk.domain.product.product.ProductMapper;
import ee.valiit.back_vali_kuusk.domain.product.product.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TreeOrderService {
    @Resource
    private OrderService orderService;

    @Resource
    private DeliveryService deliveryService;

    @Resource
    private SessionService sessionService;

    @Resource
    private ProductService productService;

    @Resource
    private OrderProductService orderProductService;

    @Resource
    private ProductMapper productMapper;

    public OrderResponse getNewOrderId(Integer sessionId) {
        Session session = sessionService.findBySessionId(sessionId);
        Delivery delivery = deliveryService.findByDeliveryId(2);

        Order order = createBlankOrder(session, delivery);

        orderService.addOrder(order);
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setOrderId(order.getId());
        return orderResponse;
    }

    private static Order createBlankOrder(Session session, Delivery delivery) {
        Order order = new Order();
        order.setAddress("");
        order.setEmail("");
        order.setPhoneNumber(0);
        order.setFirstName("");
        order.setLastName("");
        order.setStatus("P");
        order.setDelivery(delivery);
        order.setSession(session);
        return order;
    }

    public void createNewOrderProduct(Integer orderId, Integer productId) {
        Order order = orderService.findOrderBy(orderId);
        Product product = productService.findProductBy(productId);
        product.setStatus("P");
        productService.save(product); //Kas on vaja save-ida?
        orderProductService.createNewOrderProduct(order,product);


    }

    public List<ShopResponse> getTreeByOrderId(Integer orderId) {
        List<Product> products = orderProductService.findOrderProductBy(orderId);
        List<ShopResponse> productsToCartResponse = productMapper.productsToShopResponse(products);
        return productsToCartResponse;
    }

    public void changeTreeStatusBackToA(Integer productId) {
        Product product = productService.findProductBy(productId);
        product.setStatus("A");
        productService.save(product);
    }

    public long getProductCount(Integer orderId) {
        long count = orderProductService.getProductCount(orderId);
        return count;
    }

    public void removeTreeFromOrderProduct(Integer productId) {
        orderProductService.deleteTreeById(productId);

    }
}
